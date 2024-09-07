const val STRING_REPEAT_CONSTANT = 500

const val DONE_STRING = "StringTesterDoneString"

const val REQUEST_URL = "https://ginandjuice.shop/"

const val HTTP_REQUEST_STRING_GET_GIN_HTTP1 = """GET / HTTP/1.1
Host: ginandjuice.shop
Accept-Language: en-GB
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.6533.100 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
Accept-Encoding: gzip, deflate, br

"""

const val HTTP_RESPONSE_STRING_GET_GIN_HTTP1 = """HTTP/1.1 200 OK
Date: Wed, 04 Sep 2024 22:38:02 GMT
Content-Type: text/html; charset=utf-8
Content-Length: 38
X-Frame-Options: SAMEORIGIN

<h1>hello, just some fake content</h1>"""

const val HTTP_REQUEST_STRING_GET_GIN_HTTP2 = """GET / HTTP/2
Host: ginandjuice.shop
Accept-Language: en-GB
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.6533.100 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
Accept-Encoding: gzip, deflate, br

"""

const val HTTP_RESPONSE_STRING_GET_GIN_HTTP2 = """HTTP/2 200 OK
Date: Wed, 04 Sep 2024 22:38:02 GMT
Content-Type: text/html; charset=utf-8
Content-Length: 38
X-Frame-Options: SAMEORIGIN

<h1>hello, just some fake content</h1>"""