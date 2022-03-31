# newlearn
[팀 프로젝트] NewLearn : 강의 홈페이지 제작


# 1. 개요 및 주제

뉴런은 **온라인 교육 사이트** '인프런' 을 참고해 진행한 프로젝트입니다.

팀원 모두가 인프런에서 제공하는 좋은 강의들을 들으며 열심히 공부하고 있었습니다. 

**모두가 도움 받고 있는 이 양질의 사이트를 우리도 한번 만들어보자!** 라는 마음으로 시작하게 되었습니다.

---

# 2. 기술스택

### **Back-end**

- Java 11
- Spring Boot 2.4.5
- Spring security
- MyBatis
- Gradle

### Database

- MySQL

### Front**-end**

- html
- css
- Javascript

---

# 3. ERD

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bac3084e-8ba2-4936-9baf-126f0ae30268/Untitled.png)

---

# 4. 핵심 기능

- ▶ 표시는 토글버튼 입니다. **자세한 내용을 보시려면 펼쳐주세요!**
- 토글 모두 열기 - (MAC)  **cmd + option + t**   /   (Window)  **ctrl + alt + t**

### 👨 관리자 모드

- 회원 관리 시스템
    - 전체 회원 조회 , 검색, 삭제
    [ ROLE_ADMIN ] 권한을 가지고 있는 member는 회원 관리 시스템에 접근이 가능하다.
    
    ```java
    
    < 전체 회원 조회 >
    @GetMapping("/admin/members")
    public String selectAllMember(Criteria cri, Model model, Authentication auth) {
        log.info(" ::::[관리자] 전체회원 조회 controller:::::::::::: ");
    
        List<MemberDTO> memberDTOS = new ArrayList<>();
        memberDTOS = memberService.selectAllMember(cri);
    
        model.addAttribute("auth", auth);
        model.addAttribute("result", memberDTOS);
        model.addAttribute("pageMaker", new PageDTO(cri, memberService.getTotal()));
    
        return "admin/adminMember";
    }
    
    < 체크된 회원 삭제 >
    @DeleteMapping("/admin/member")
    public String deleteMember(@RequestParam("delete") List<String> ids){
        log.info(" ::::[관리자] 선택 회원 삭제 controller::::::::::: ");
    
        if (ids != null) {
            for(String idStr : ids){
                int id = Integer.parseInt(idStr);
                memberService.memberDelete(id);
            }
        }
        return "redirect:/admin/member";
    }
    ```
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/54d9e4f5-7ee1-42ca-9692-6e6355b159af/Untitled.png)
    

### 📌 회원 가입 및 로그인

- 회원 가입
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/cc298b05-ba74-4dda-b8d8-365bbadef7b7/Untitled.png)
    
- 로그인
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/5152ebed-7380-4dbc-a43e-3a1c1b880acc/Untitled.png)
    

### 📺 강의

- 강의 등록
    
    < 강의 등록 및 썸네일 미리보기 >
    
    강의에 대한 세부 정보 작성 후 썸네일 파일을 첨부하면 썸네일 미리보기가 가능하다.
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b89fae84-7fa6-4316-8b70-456ac422c62c/Untitled.png)
    
    < 세부 강의 등록 >
    
    동영상 파일 선택 후 강의 제목을 적고 제출을 누르면 강의가 등록된다.
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6065e77b-92f8-43c8-ba08-1bb5663641aa/Untitled.png)
    
    등록된 세부 강의는 강의 페이지의 '교육과정'파트에서 순서대로 보여진다. 
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/617c0ad1-3950-48ba-8767-b882ca24bc9c/Untitled.png)
    
    강의 제목을 클릭하면 동영상이 재생된다.
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/38296cfd-e971-4aab-a548-229c77415001/Untitled.png)
    

### ✏ 수강 후기

- 후기 작성
    
    < 후기 작성 모달창 > 및 수강후기 
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a39b08ae-aebd-432c-b776-d4b67c7545f2/Untitled.png)
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d037dcb0-deca-4ba3-9e18-9ed948a3de05/Untitled.png)
    

### 📬 비밀번호 찾기

- 이메일로 임시 비밀번호 전송
    
    

### 🛒 장바구니

- 장바구니에 강의 담기 및 삭제하기
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a2028cbd-9bc1-4756-ab11-c95a98be8148/Untitled.png)
    
- 쿠폰 적용
    
    쿠폰코드 입력 후 적용버튼 클릭
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d4b987ef-d928-4cac-a0ef-95d24adfdb97/Untitled.png)
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f51233aa-42ed-45bd-8cab-7308983b36d0/Untitled.png)
    
    총 가격에 쿠폰 할인 반영된다.
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/91d1bbff-526b-4efe-a56d-b4158d889157/Untitled.png)
    

### 💰 결제

- 결제 API 사용
    - 아임포트 결제 API 사용
    - 결제를 위한 기본사항 작성 후 결제하기 클릭 →  KG이니시스 결제 창에서 결제 진행
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/0ab79c56-ea13-4b7b-a9bb-48dea12f9082/Untitled.png)
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e38e3904-470c-4912-84a1-a9b33a9983c4/Untitled.png)
    

### 🔍 마이페이지

- 이름 및 비밀번호 변경
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/dba49b0a-6d12-40f6-8f04-b76b0bb039b4/Untitled.png)
    

---

# 5. 리팩토링 및 기능 보완

## 1) REST API 설계

- 문제점 및 이유 / 리팩토링 결과
    
    
    ### 🚩 문제점
    
    **API 아키텍처 디자인에 대한 고려 없이** 일단 기능이 돌아가도록 만들었다.
    한마디로 API **설계 보다는 기능이 수행되도록** 코드를 먼저 작성하였던 것이다.
    하지만 프로젝트 완성 후, 각자가 설계한 API는 **통일감이 없었고 RESTful API와는 완전히 거리가 멀었다.**
    
    ### 💡REST API 설계 이유 ****
    
    API는 시스템 전체의 구성, 동작, 환경에 대한 **직관적 이해**를 돕는 설계도라고 할 수 있다.
    리팩토링 전 API는 통일감 없는 구성과 이해하기 힘든 구조였다.
    그래서 아래 **REST API 기본 규칙**에 따라 **리팩토링**하였다.
    
    (1) URL은 정보의 자원을 표현해야 한다.
    
    (2) 자원은 동사보다는 명사를, 대문자보다는 소문자를 사용한다. 
    
    (3) 자원에 대한 행위는 HTTP Method로 표현한다.
    
    (4) 여러 요소들로 이루어진 자원은 복수로 표현한다.
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/345f62f6-a961-4c6a-bd62-c5ca763ca867/Untitled.png)
    
    ---
    

---

# 6. 핵심 트러블슈팅

1. aws - s3
2. 스프링 시큐리티 현재 접속 회원 받아오기
3. ERD 설계를 할 때 많은 어려움을 겪었고,
협업에서의 트러블슈팅!

---

# 7. 그 외 트러블슈팅

1. 코드 구현 후 다시보니  못알아보겠다 > 클린코드, 리팩토링에 중요성
2. 사소한 오타 문제, 원인모를문제 >> 에러, 로그 읽는법, 디버깅 중요성
3. 협업간에  개발 시 코드  표준화 ,  테스트 코드의 중요성
4. 라이브러리 버전 호환 문제 발생?

---

# 8. 회고 및 성장

처음으로 진행한 프로젝트라 나에겐 아주 의미 있는 프로젝트였다.
공부와 실전은 다르다는 것을 절실히 체감했다.
SpringBoot, gradle 등 조금은 낯선 환경이였다. 
그래서인지 처음엔 DB연결에서부터 오류가 발생했고, 단순CRUD도 겨우겨우 해냈다.
이후 **장바구니 기능**을 개발하며 crud가 조금씩 익숙해졌고
**결제 기능**을 개발하며 외부 api 사용 성공에 굉장히 뿌듯했다. 실제로 결제가 됐을 땐 신기하고 감동적이였다.
그리고 **쿠폰 기능**은 어떤 로직으로 개발해야 할지 혼자 고민해보고 구현한 것이 내 생각대로 동작 되는 그 순간 정말 희열을 느꼈다. 물론 아주 간단한 로직이였지만 ...샬라샬라
**댓글 기능** 개발시에는 api통신 서버 구축................................

각 기능을 개발해나가며 어떻게 개발할지에 대한 막연함이 사라졌다.
