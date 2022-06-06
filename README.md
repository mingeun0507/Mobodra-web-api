# Mobodra-web-api

Mobodra의 웹 API입니다.

## Usage

*   [GET](#GET)
*   [POST](#POST)
*   [DELETE](#DELETE)


## GET
- 메인 페이지: /main
- 현재 로그인한 ID가 좋아요 표시한 콘텐츠에 따라 콘텐츠들을 추천하여 전달(최대 길이 1010의 List)
```
[
    {
        "id": "1",
        "contentType": "book",
        "title": "Breaking Dawn (The Twilight Saga, Book 4)",
        "year": "2008",
        "imageLink": "https://bookthumb-phinf.pstatic.net/cover/047/134/04713402.jpg?type=m1&udate=20090128"
    },
    {
        "id": "575",
        "contentType": "movie",
        "title": "Titanic",
        "year": "1997",
        "imageLink": "https://ssl.pstatic.net/imgmovie/mdi/mit110/0188/18847_P96_094922.jpg"
    }
]
```

## POST

- 회원가입: /members/sign-up
- 성공 시 true, 실패 시 false 리턴
```
{"loginId": "test", "loginPw": "test", "nickname": "nickname-test"}
```

- 로그인: /members/login
- 성공시 true, 실패 시 false 리턴
```
{"loginId": "test", "loginPw": "test"}
```

- 선호도 조사: /likes/survey/first
- 성공 시 true, 실패 시 false 리턴
- memberId는 임의의 값으로 등록해도 무방(세션 ID 받아와서 사용)
```
[{"contentId": "1", "memberId": "0"}, {"contentId": "2", "memberId": "0"},
 {"contentId": "3", "memberId": "0"}, {"contentId": "4", "memberId": "0"}]
```

- 좋아요: /likes/survey
- 성공 시 true, 실패 시 false 리턴
- memberId는 임의의 값으로 등록해도 무방(세션 ID 받아와서 사용)
```
{"contentId": "1", "memberId": "0"}
```

## DELETE

- 선호도 재조사를 위한 좋아요 표시 전체 삭제: /likes/survey/first
- 성공 시 true, 실패 시 false 리턴
- json 바디 필요 X

- 좋아요 취소: /likes/survey
- 성공 시 true, 실패 시 false 리턴
- memberId는 임의의 값으로 등록해도 무방(세션 ID 받아와서 사용)
```
{"contentId": "1", "memberId": "0"}
```
