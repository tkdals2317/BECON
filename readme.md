
# Project : Be Con!

## Description

> 프로젝트의 개요와 간략한 설명을 작성합니다



## Specification

> 프로젝트의 명세입니다

### 배포 환경

- __URL__ : 
- __배포 여부__ : O / X
- __접속 가능__ : 접속 가능 / 수정 중
- __HTTPS 적용__ : O / X
- __PORT__ : // 3rd Party에서 사용하는 포트가 있다면 기입해주세요. <- 기입 후 해당 주석 삭제
  <br>

### 개발 환경

#### Front-end 

- __Framework__ : Vue.js
- __지원 환경__ : Web / Mobile / Web App / Native App
- __담당자__ : 팀원 황배근, 팀원 권준엽
  <br>

#### Back-end

- __Framework__ : Spring boot / Node.js / Docker 
- __Database__ : MySQL 
- __담당자__ : 팀장 이상민, 팀원 안진흥, 팀원 강민주
  <br>

#### Design

- __Framework 사용__ : O
  - 
- __Design Tool 사용__ : 
- __담당자__ : 팀원 A, 팀원 B,
  <br>

### Design Resources

__외부 템플릿 또는 에셋__ (이미지 또는 링크 첨부)

- 무료 이미지, 아이콘, 폰트 등은 제외
- [Linoor - Vue Nuxt Digital Agency Services Template](https://themeforest.net/item/linoor-vue-nuxt-digital-agency-services-template/29146481) (유료)
  - __사용 기능__ : 프로젝트 전체적인 프레임 및 컴포넌트 사용
    <br>

__자체 제작 산출물__ (필요시 이미지 또는 설명 첨부)

- LOGO
  <br>

### 핵심 라이브러리

기본 제공하는 라이브러리 외 핵심 기능 구현에 사용한 라이브러리가 있다면 작성해주세요.   
예시 ) VR/AR 라이브러리, 애니메이션 라이브러리, 텍스트/사진/동영상 지원, 편집 라이브러리 등



## Usage

> 프로젝트 사용법을 작성합니다



## Rules

> 협업을 위해 개발에 필요한 여러 규칙들을 정의합니다

### GIT 규칙

- 작업단위로 브랜치 생성하여 작업하기
- 브랜치 구조 : master - develop(한개) - 기능별 브랜치 이름(역할 분배 된 대로)

- 브랜치명 규칙 : BE-WebRTC, FE-ConferencePopup
- Merge 규칙 : 명세서 기반, 지라 기준 한개의 작업 또는 한개의 부작업 구현 완료시 Merge
- 수정 시 modify 기능명, 추가 시 add 기능명, 삭제시 delete 기능명, 
- 반드시 다른 사람에게 코드 리뷰를 받은 후 merge 할 것

---

### JIRA 규칙

- 큰틀은 BE, FE로 구분
- 명세서 기준 스토리는 분류, 작업은 제목, 부작업은 명세의 기능으로 구성한다 
- 작업은 작업을 포함하는 스토리를 이슈에 연결하여 생성
- 부작업은 작업에서 더많은 조치에서 생성
- 담당자와 스토리포인트 설정하기
- 스프린트에서 상태 변경하기

---

### 파일명 및 변수명 규칙

- vue 관련 파일명 : 소문자로만 구성, 띄어쓰기시 - 로 구분

- Spring 관련 파일 : 파스칼 표기법, 카멜 표기법과 동일하지만 첫 글자를 대문자로 표기 ex) PascalCase

- 메소드의 이름은 대소문자 혼용 가능하지만 반드시 동사를 사용하여 소문자로 시작 ex) checkRange()

- 그 외 일반적인 변수 : 카멜 표기법, 각 단어의 첫글자는 대문자로 하되, 첫 글자만 소문자로 표기 ex) camelCase 

- 엔티티의 멤버 변수 이름은 DB에 있는 변수명을 기본

- is 접두사를 통해 boolean변수를 표기한다 ex) 로그인이 되었는지 체크하는 변수 :  isLogin

- n 접두사를 통해 객체의 개수를 나타내는 변수를 표기한다 ex) nUser

- No 접미사를 통해 엔티티 번호를 나타낸다 ex) userNo, coferenceNo

- 상수의 경우 대문자로 표기한다 ex) 회원의 등급 : USER_GUEST, USER_ADMIN

- 최대한 직관적으로  작성 ex) ~num, ~cnt, 

## 용어집


## 라이센스

> 프로젝트에 사용된 라이선스를 표기합니다

