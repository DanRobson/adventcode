package util

class Data {
    public static HttpURLConnection getCalories()
    {
        // This is behind oauth for some ungodly reason and I cba to implement that flow
        def puzzle = new URL("https://adventofcode.com/2022/day/1/input").openConnection() as HttpURLConnection
        puzzle.setRequestMethod("GET")
        puzzle.setRequestProperty( 'User-Agent', 'groovy-2.4.4' )
        // So fake the cookie
        puzzle.setRequestProperty("cookie", "session=53616c7465645f5fffecc0858882b1d1ecb91a5b5249f3fc26dc622582922643f99dbe48a91058d46dd55bdbcfecd0a2528e2734801579cbce0bf0552dfbacb6")
        puzzle.setRequestProperty( 'Accept', 'text/html' )
        return puzzle
    }

}
