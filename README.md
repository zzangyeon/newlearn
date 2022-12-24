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
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/00d51f58-0ccb-4b35-af04-3ff6d668b2d0/Untitled.png)
    

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
