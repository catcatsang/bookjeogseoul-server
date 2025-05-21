![image](https://github.com/user-attachments/assets/1f8c67cc-e3f4-473a-84d2-2bc19548e92a)![image](https://github.com/user-attachments/assets/eb48a0d8-11e0-4d07-9bef-a69ec93aa87f)# 독서 커뮤니티, 도서 기부 플랫폼 - '북적북적'

## 1. 기획 의도

#### 1. 서비스 제작배경 및 필요성

![제작 배경](temp-statistics.png)

디지털화가 가속화되면서 종이책을 통한 독서가 감소하고, 독서 문화 역시 약화되고 있습니다. 
또한, 독서의 중요성은 여전히 강조되고 있지만 이를 장려하거나 독서 경험을 공유할 수 있는 플랫폼은 부족한 실정입니다.
특히, 청소년과 성인 모두 독서 습관을 유지하고 독서의 즐거움을 공유할 수 있는 온라인 공간이 필요합니다. 

이러한 배경 속에서 북적서울은 독후감 작성 및 공유를 통해 독서 문화 확산을 도모하고, 공공데이터를 활용한 도서 추천 시스템을 통해 독서 활동을 더욱 활성화시키고자합니다.



## 2. 기대 효과

![기대 효과](temp-whyuseus.png)

독서 활동의 보상으로 기부에 참여할 기회를 제공함으로써, 사람들이 독서의 즐거움을 더욱 느끼고, 이를 통해 자연스럽게 독서에 대한 관심과 참여가 증가할 수 있다. 또한, 이러한 방식은 독서의 가치를 사회적 기여와 연결하여 더욱 의미 있는 경험으로 확장할 수 있습니다.

후원 단체를 통해 도서를 접하기 힘든 사람들에게 도서를 후원함으로써, 더 많은 사람들에게 독서로 얻을 수 있는 긍정적인 효과를 나눌 수 있음.



## 3. 프로젝트 사용 툴

-   Java
-   Java Spring Data
-   QueryDSL
-   Java Script
-   tomcat
-   ORACLE
-   Spring Boot
-   Visual Studio Code
-   DBeaver
-   Sourcetree
-   git, github
-   JSON
-   Ajax
-   JDK 11.0.15
-   Kakao DEVELOPER API
-   SMTP Gmail API
-   Slack

## 4. ERD

![ERD](../)

## 5. 담당업무

### 5-1 서버(server)

![퍼블리싱](../)

> 로그인

-   로그인 
-   단체 로그인 
-   비밀번호 찾기(단체 포함)
-   관리자 로그인
-   일반 회원가입
-   카카오 회원가입 추가정보입력창
-   이메일 인증 비밀번호찾기
  

> 메인 화면

-   서울도서관 api
-   알라딘 api


> 카테고리
- 카테고리별 도서 조회

> 댓글 유사도 검사
> 
- 댓글 비속어 검사 AI 활용

## 6. 트러블 슈팅


### 6-1 API 조회 도중 오류발생

[이슈 발생 화면]
<img src="https://github.com/catcatsang/bookjeogseoul-server/blob/master/OpenAPI-error.png"><br>

서울 도서관과 알라딘 api 를 섞어 사용하던도중 오류가 발생했는데, 잘 읽어보니 Publisher 필드가 없다고 나옴, 

[코드 상태]
<img src="https://github.com/catcatsang/bookjeogseoul-server/blob/master/vo%20%EC%97%86%EB%8A%94%20%EC%82%AC%EC%A7%84.png"><br>

1차와는 다르게 침착하게 publisher를 찾을수없다하니 VO 먼저 보게되었다. 역시나 Publisher 가없어서 추가해줫다

[완성 상태]
<img src="https://github.com/catcatsang/bookjeogseoul-server/blob/master/bookinfo%20%EC%88%98%EC%A0%95.png"><br>
고쳐주니 완벽하게 조회성공하였음, 
API를 처음사용할때 출력을 한번 해보고나니 쉬웠다, 대부분의 오류는 필드가없거나, 오타였다.
<br>

### 6-2 Mapper Namespace 매핑

[이슈 발생 화면]
<img src="https://github.com/catcatsang/bookjeogseoul-server/blob/master/mapper%20%EC%98%A4%EB%A5%98%20%EB%A1%9C%EA%B7%B8.png"><br>
서버가 아예 실행이 되지않으면서 갑자기 이런 오류가떳다, 서버가 안켜져서 당황했지만 오류를 확인해보니 
memberMapper에 문제가 생겻다고한다. 변수 잘 전달했고 문제는없었다 뭐가문제인지 몰랐다.

[코드 상태]
천천히 끝에서부터 차례로 모든걸 봣다. 메소드 이름 부터 코드 끝까지 , 클래스마다 다 확인해보니, mapper.xml name 과 mapper.java 의 메소드명이 달랏다

[완성 상태]
곧바로 고쳐줫다. 이제 오타는 줄어들었다고 생각했는데 mapper name 값이 다르면 안돼는걸 알았지만, 서버가 아예 안켜지는건 처음알았다, 그래서궁금해서 찾아봤다
xml 의 namespace와 package 경로, 및 이름이 완벽히 일치해야한다는걸 다시한번 느끼게되어 mapper 이름 불일치로 출력되는 오류는 2차프로젝트에서 완벽히 고쳣다.


### 6-3 아무이유없는 null

[이슈 발생 화면]
<img src="https://github.com/catcatsang/bookjeogseoul-server/blob/master/no%20reason%20null.png">
로그가 안찍히는 null이다. 이 오류가 떳을때는 정말 생각이 멈췃는데 무엇이 문제인지 몰랏다. 2시간 3시간넘게 매달리다, 다시한번 천천히 꼼꼼하게 처음부터 끝까지 봣다 
mapper 로 가는길을 의심했다. 
[코드 상태]
```
 @PostMapping("sponsor-change-passwd")
    public String changePasswd(String newPasswd, HttpSession session) {
        sponsorMemberDTO.setSponsorEmail((String) session.getAttribute("email"));
        String memberEmail = sponsorMemberDTO.getSponsorEmail();
        log.info("memberEmail: " + memberEmail);

        if (memberEmail != null) {
            log.info("memberEmail: " + memberEmail);
            sponsorServiceImpl.changePassword(sponsorMemberDTO, newPasswd);
            session.invalidate();
            return "redirect:/personal/Login";
        }

        return "/personal/login?result=tokken-lose";
    }
```


어디부터 만져야할지 몰랏다, 로그를 하나씩 다 찍어보면서 문제를 파악하니 if 안으로 들어가지않음, 그래서 그냥 코드 자체를 바꿧다. 

[완성 상태]
<img src="https://github.com/catcatsang/bookjeogseoul-server/blob/master/null%20%EC%98%A4%EB%A5%98%20%ED%95%B4%EA%B2%B0.png"><br>

그래서 그냥하나씩 수정하며 나온 원인은 changePassword 에 DTO 에 password 를 담아서 같이 보내주면 됫다, 그리고 memberEmail 을 null 로검사하지말고 isEmpty 로 바꿧다. 
이 시점부터 Optional 에 관심이 더 생기기 시작했고 null 이라는게 어떤 것인지 궁금했다. null 은 기본적으로 사용하기엔 꺼려지는 코드라고 나오고 대부분 boolean 으로 check 하거나 Optional 로 감싸서 사용한다고한다.
이 오류로 인해서 null 처리에 대해 관심이 깊어졋다.
수정한뒤 완벽하게 작동이 되었다.







## 7. 느낀점

-   ***역시 퍼블리싱보단 서버가 더 재밌었다*** 힘든것도 맞고, 오류를 찾는것도 힘들지만 하고나면 얻는정보와 기술이 상당히 많아서 너무 좋다.

-   배울때 당시에는 관심이 크게 안가던 null 이라던가 optional 이라던가 mapper 등등 오류로 인해서 더 많이 배우는거같다. 사실 팀프로젝트를 더 하고싶다.

-   2차에서는 확실하게 서비스쪽이 크게 늘었다. 코드를 잘적는 팀원 기술도 흡수가빨라졋고 가르침 받는것과 생각하는것도 달라졋다.

서버 개발이 나에게 훨씬 더 잘 맞는다는 걸 이번 프로젝트를 통해 확실히 느꼈다. 물론 오류를 찾고 해결하는 과정은 쉽지 않았지만, 그만큼 얻는 지식과 경험이 크다는 점에서 큰 보람을 느꼈다. 처음엔 관심이 덜했던 null, Optional, mapper 같은 개념들도 실전에서 직접 부딪히며 더 깊이 이해하게 되었고, 이 과정에서 진짜 많이 성장했다.

특히 2차 프로젝트에서는 서비스 로직 구현에 자신감이 붙었고, 팀원들의 코딩 스타일과 노하우를 빠르게 흡수하면서 나만의 기준도 조금씩 생긴 것 같다. 배울수록 더 배우고 싶다는 마음이 커졌고,  실력은 아직 완벽하진 않지만, 점점 나아지고 있다는 확신이 생긴다. 지금 이 성장을 꾸준히 이어가고 싶다.
