package util

import org.apache.commons.io.FileUtils

class Data {
    public static File getCalories()
    {
        return cacheDataLocally("dayone.txt", "https://adventofcode.com/2022/day/1/input")
    }

    public static File getStrategies()
    {
        return cacheDataLocally("daytwo.txt", "https://adventofcode.com/2022/day/2/input")
    }

    private static File cacheDataLocally(String fileName, String uri)
    {
        File localData = new File(fileName)
        if (!localData.exists())
        {
            localData.createNewFile()
            var puzzleInput = retrieveData(uri)
            FileUtils.copyInputStreamToFile(puzzleInput.inputStream, localData)
        }
        return localData
    }

    private static HttpURLConnection retrieveData(String uri)
    {
        def puzzle = new URL(uri).openConnection() as HttpURLConnection
        puzzle.setRequestMethod("GET")
        puzzle.setRequestProperty( 'User-Agent', 'groovy-2.4.4' )
        // So fake the cookie
        puzzle.setRequestProperty("cookie", "session=53616c7465645f5fffecc0858882b1d1ecb91a5b5249f3fc26dc622582922643f99dbe48a91058d46dd55bdbcfecd0a2528e2734801579cbce0bf0552dfbacb6")
        puzzle.setRequestProperty( 'Accept', 'text/html' )

        if (puzzle.responseCode != 200)
        {
            throw new Exception("Unable to access puzzle data: " + puzzle.responseMessage)
        }

        return puzzle
    }

}
