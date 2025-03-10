--모든 사람의 정보를 보여줘
SELECT * FROM EMPLOYEE;
--모든 사원의 이름, 주민등록번호, 핸드폰번호
SELECT EMP_NAME,EMP_NO,PHONE
FROM EMPLOYEE;
---JOB테이블의 직급명 컬럼만 조회
SELECT JOB_NAME
FROM JOB;
--DEPARTMENT 테이블의 모든 컬럼 조회
SELECT *
FROM DEPARTMENT;
--DEPARTMENT 테이블의 부서코드,부서명 조회
SELECT DEPT_ID,DEPT_TITLE
FROM DEPARTMENT;
--EMPLOYEE 테이블의 사원명,이메일,전화번호,입사일,급여조회
SELECT EMP_NAME,EMAIL,PHONE,HIRE_DATE,SALARY
FROM EMPLOYEE;
--EMPLOYEE테이블의 사원명,사원의 연봉(SALARY*12)를 조회
SELECT EMP_NAME,SALARY*12
FROM EMPLOYEE;
--EMPLOYEE테이블의 사원명,급여,보너스,사원의 보너스 포함 연봉((급여+(급여+보너스)*12)를 조회
SELECT EMP_NAME,SALARY,BONUS,((SALARY+(SALARY*BONUS))*12)
FROM EMPLOYEE;
--사원명, 입사일,근무일수를 EMPLOYEE 테이블에서 조회
SELECT EMP_NAME,HIRE_DATE,ROUND(SYSDATE-HIRE_DATE)
FROM EMPLOYEE;
/*
        
        <컬럼에 별칭 지정하기>
        산술연산을 하게되면 컬럼명이 지저분해진다.이때 컬럼명에 별칭을 부여해서 깔끔하게 가져올 수 있다.
        [표현법]
        컬럼명 별칭 / 컬럼명 AS 별칭 / 컬럼명 "별칭" / 컬럼명 AS "별칭"
        
*/

/*

        <리터럴>
        임의로 지정한 문자열('')
        
*/
--EMPLOYEE테이블의 사번,사원명,급여
SELECT EMP_ID,EMP_NAME,SALARY,'원' 단위
FROM EMPLOYEE;

/*

        <연결연산자: ||>
        여러 컬럼값들을 마치 하나의 컬럼처럼 연결할 수 있다.
        
*/
--EMPLOYEE 테이블에서 모든 사원의 월급을 조회한다.
--다음과 같이 결과가 나오도록 출력해라
--XX의 월급은 XX원입니다.
SELECT EMP_NAME||'의 월급은 '||SALARY||'원 입니다.'
FROM EMPLOYEE;
/*

        <DISTINCT>
        중복제거-컬럼에 표시된 값들을 한 번씩만 조회하고 할 때 사용
        
*/
--SELECT DISTINCT JOB_CODE, DISTINCT DEPT_CODE
--위처럼 작성시 에러가 발생한다. DISTINCT 한 명령어에서 한 번만 사용가능
--위처럼 사용 시 JOB_CODE, DEPT_CODE를 쌍으로 묶어서 중복을 제거한 값을 보여준다.
SELECT DISTINCT JOB_CODE,DEPT_CODE
FROM EMPLOYEE;
/*

        <WHERE 절>
        조회하고자 하는 테이블로부터 특정 조건에 만족하는 데이터만 조회할 때 사용한다.
        조건식에서도 다양한 연산자를 사용할 수 있다.
        
        [표현법]
        SELECT 컬럼,컬럼,컬럼
        FROM 테이블명;
        WHERE 조건;
        
        >>비교연산자<<
        >,<,>=,<= :대소비교
        =:양쪽이 동일하다.
        !=,^=,<>: 양쪽이 다르다.
        
*/

--EMPLOYEE 테이블에서 부서코드가 D9인 사원들만 조회 (모든 컬럼)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE='D9';
--EMPLOYEE에서 부서코드가 'D1'인 사원들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME,SALARY,DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE='D1';
--EMPLOYEE에서 부서코드가 'D3'가 아닌 사원들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME,SALARY,DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE!= 'D3';
--월급이 400만원 이상인 사원들의 사원명,부서코드,급여 조회
SELECT EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE SALARY >=4000000;

-----------------실습-----------------
--1. 급여가 300만원 이상인 사원들의 사원명,급여,입사일, 연봉(별칭-->연봉)조회
--2. 연봉이 5천만원 이상인 사원들의 사원명, 급여, 연봉 (별칭--> 연봉), 부서코드 조회
SELECT EMP_NAME,SALARY,(SALARY+(SALARY*NVL(BONUS,0)))*12 연봉,DEPT_CODE
FROM EMPLOYEE
WHERE (SALARY+(SALARY*NVL(BONUS,0)))*12 >=50000000;
--3. 직급코드가 'J3'가 아닌 사원들의 사번, 사원명, 직급코드, 퇴사여부 조회
SELECT EMP_ID,EMP_NAME,JOB_CODE,ENT_YN
FROM EMPLOYEE
WHERE JOB_CODE !='J3';
--4. 급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여 조회
SELECT EMP_NAME,EMP_ID,SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;
--입사일이 '90/01/01'이상 '01/01/01'이하인 사원들을 전체 조회

-- NULL을 비교연산할때는 =를 사용할 수 없다.
SELECT *
FROM EMPLOYEE
--WHERE BONUS IS NULL;
WHERE BONUS IS NOT NULL;

SELECT EMP_ID,EMP_NAME,SALARY  --3
FROM EMPLOYEE                  --1
WHERE DEPT_CODE='D2';          --2

--1,2,3은 실행 순서 

--전 사원의 사원명, 연봉 조회(이 때 연봉을 기준으로 내림차순 정렬)
--전 사원의 보너스 내림차순으로 조회,그리고 정렬기준에 컬럼값이 동일할 경우 급여 오름차순
SELECT EMP_NAME,(SALARY+NVL(SALARY*BONUS,0))*12,BONUS
FROM EMPLOYEE
ORDER BY BONUS DESC;
--단일행 함수: N개의 값을 읽어들여서 N개의 결과값을 리턴(매행마다 함수실행결과를 반환)
--그룹함수: N개의 값을 읽어들여서 1개의 결과값을 리턴(그룹을 지어 그룹별로 함수 실행결과를 반환)

<문자 처리 함수>
*LENGTH(컬럼 | '문자열'): 해당 문자열의 글자수를 반환
*LENGTHB(컬럼 | '문자열'): 해당 문자열의 바이트수를 반환
'최' '나' 'ㄱ' 한글은 글자당 3BYTE
영문자, 숫자, 특수문자 글자당 1BYTE

--함수 중첩사용 가능
--이메일 아이디 부분만 추출
--사원목록에서 사원명,이메일,아이디 조회

--문자열 'AABAACAABBAA'에서 B가 두 번째로 나오는 위치
SELECT INSTR('AABAACAABBAA','B',1,2) FROM DUAL;
--문자열 'AABAACAABBAA'에서 B가 제일 뒤에 나오는 위치
SELECT INSTR('AABAACAABBAA','B',-1,1) FROM DUAL;
--이메일에서 '_'의 위치를 나타내고 별칭으로 "LOCATION",'@'의 위치를 나타내고 별칭으로 "@위치"를 나타내시오
SELECT INSTR(EMAIL,'_') AS "LOCATION",INSTR(EMAIL,'@',1) AS "@위치",EMAIL
FROM EMPLOYEE;
--'SHOWMETHEMONEY'문자열을 5번째 글자부터 시작해서 2개의 문자를 추출해라
SELECT SUBSTR('SHOWMETHEMONEY',5,2) FROM DUAL;
--사원들 중 여사원들만 EMP_NAME, EMP_NO를 조회
SELECT EMP_NAME,EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) IN(2,4);
--사원들 중 남사원들만 EMP_NAME, EMP_NO를 조회

--30만큼의 길이 중 EMAIL컬럼값은 오른쪽으로 정렬하고 나머지 부분은 공백으로 채운다.
SELECT LPAD(EMAIL,30,'#') FROM EMPLOYEE;
--30만큼의 길이 중 EMAIL컬럼값은 오른쪽으로 정렬하고 나머지 부분은 '#'으로 채운다.

--사원들의 사원명,주민등록번호("123456-1XXXXXX")로 조회

/*

        *LTRIM/RTRIM
        문자열에서 특정 문자를 제거한 나머지를 반환
        LTRIM/RTRIM(컬럼 | '문자열', [제거하고자하는 문자들])
        
        문자열의 왼쪽 혹은 오른쪽에서 제거하고자 하는 문자들을 찾아서 제거한 나머지 문자열 반환
*/

/*

    *TRIM
    문자열의 앞/뒤/양쪽에 있는 저장한 문자들을 제거한 나머지 문자열 변환
    TRIM([LEADING | TRAILING | BOTH] 제거하고자하는 문자열 FROM 문자열)
    
*/

/*
        *LOWER /UPPER / INITCAP
        LOWER : 다 소문자로 변경한 문자열 반환
        UPPER : 다 대문자로 변경한 문자열 반환
        INITCAP: 띄어쓰기 기준 첫 글자마다 대문자로 변경한 문자열 반환
        
*/

/*
    *CONCAT
    문자열 두 개 전달받아서 하나로 합친 후 반환
    CONCAT (STRING1,STRING2)
*/

SELECT CONCAT('가나다','ABC') FROM DUAL;
SELECT '가나다' || 'ABC' FROM DUAL;

--EMAIL을 불러오는데 EMAIL에서'C##SERVER'를 'KH'로 변경하여 추출

/*

    *MOD
    두 수를 나눈 나머지 값을 반환
    MOD(NUMBER, NUMBER)
*/

/*
    <숫자처리함수>
    *ABS
    숫자의 절대값을 구하는 함수
*/

/*

    *ROUND
    반올림한 결과를 반환
    ROUND(NUMBER, [위치])
*/

--숫자 '123.456'에서 소수점 첫번째 자리에서 반올림하라
--숫자 '123.456'에서 반올림하여 소숫점 한 자리 수까지 나오도록
SELECT ROUND(123.456,-1) FROM DUAL; --음수로 감소할수록 소수점 앞자리로 이동

/*

    #CEIL
    올림처리를 위한 함수
    CELL(NUMBER)
*/

SELECT CEIL(123.456) FROM DUAL;

/*

    #TRUNC, FLOOR
    버림처리 함수
    FLOOR(NUMBER)
*/

SELECT TRUNC(123.456) FROM DUAL;
SELECT TRUNC(123.952,1) FROM DUAL;
SELECT TRUNC(123.952,-1) FROM DUAL;

--사원들 중에 이름에 중간에 '하'라는 글자가 포함된 사원의 이름,전화번호 출력
----사원들 중에 이름에 처음에 '하'라는 글자로 시작되고 뒤에 두 글자가 있는 사원의 이름,전화번호 출력
--사원들 중에서 전화번호 3번째 자리가 1인 사원들의 사번,사원명,전화번호 조회
--이메일 중 _앞의 글자가 3글자인 사원들의 사번, 이름 ,이메일 조회

--WHERE EMAIL LIKE '____%'; ->  _와 %는 와일드카드로 인식되기 때문에 정상적으로 출력할 수 없다.
--와일드카드와 일반문자를 구분해줘야한다.
--데이터값으로 취급하고싶은 와일드카드 문자 앞에 나만의 탈출문자를 제시해서 탈출시켜주면된다.
--ESCAPE OPTION을 등록해서 사용

--앞에 3글자가 있고,네번째 글자에 '_'가 있는 이메일을 추출하시오

--부서코드가 D6이거나 D8이거나 D5인 부서원들의 이름, 부서코드 ,급여 조회

--1.이름이 '연'으로 끝나는 사원들의 사원명,입사일 조회'
SELECT EMP_NAME,HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';
--2.전화번호 처음 세 자리가 '010'이 아닌 사원들의 사원명,전화번호 조회
SELECT EMP_NAME,PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';
--3.이름에 '하'가 포함되어있고, 급여가 240만원 이상인 사원들의 사원명,급여조회
SELECT EMP_NAME,SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%' AND SALARY >= 2400000;
--4.부서(DEPT)테이블에서 해외영업부인 부서들의 부서코드,부서명 조회
SELECT DEPT_ID,DEPT_TITLE
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '해외영업%'; 
--5.사수(MANAGER)가 없고 부서배치도 받지 않은 사원들의 사원명, 사번, 부서코드 조회
--6.연봉은 (급여*12)이 3천만원 이상이고 보너스를 받지 않는 사원들의 사번,사원명,급여,보너스 조회
--7.입사일이 '95/01/01' 이상이고 부서배치를 받지 않은 사원들의 사번,사원명,입사일,부서코드 조회
--8.급여가 200만원 이상이고 500만원 이하인 사원 중에서  입사일이 '01/01/01'이상이고 보너스를 받지 않은 사원들의 사번,사원명,급여,입사일,보너스 조회
--9.보너스를 포함하여 연봉이((SALARY+(SALARY*BONUS))*12)이 NULL이 아니고 이름에 '하'가 포함된 사원들의 사번,사원명,급여,보너스포함연봉조회

/*

    <연산자 우선순위>
    1.산술연산자
    2.연결연산자
    3.비교연산자
    4.IS NULL/LIKE/IN
    5.BETWEEN A AND B
    6.NOT
    7.AND
    8.OR
    
*/

--사원들의 사원명,입사일,근무일수,근무개월수를 조회
--*ADD_MONTHS: 특정 날짜에 NUMBER개월 수를 더해서 반환
--사원테이블에서 사원명,입사일,수습기간 종료일(+3개월)을 조회
--*NEXT_DAY(DATE,요일(문자|숫자)): 특정날짜 이후 가장 가까운 요일의 날짜를 반환
/*

    [NULL처리 함수]
*/

--*NVL(컬럼,해당컬럼이 NULL일 경우 보여줄 값)
--전 사원의 이름, 보너스 포함 연봉 조회


--*NVL2(컬럼, 반환값1,반환값2)
--반환값1 : 해당컬럼이 존재하면 보여줄 값
--반환값2 : 해당컬럼이 존재하지 않으면 보여줄 값
--사원들의 보너스가 있는지 없는지 나타내기


--* NULLIF(비교대상1,비교대상2)
--두 값이 일치하면 NULL, 일치하지 않으면 비교대상1 반환



/*
    [선택함수]
    #DECODE(비교하고자하는 대상, 비교값1, 결과값1, 비교값2, 결과값2..)
    
*/

--사번,사원명,주민등록번호,성별

--직원의 성명, 기존급여,인상된 급여 조회(각 직급별로 차등인상)
--J7직급은 급여를 10%인상(SALARY*1.1)
--J6직급은 급여를 15%인상(SALARY*1.15)
--J5직급은 급여를 20%인상(SALARY*1.2)
--그 외 직급은 급여를 5%인상(SALARY*1.05)

--사원명,급여를 조회하고 500만원 이상일 경우 고급,350만원 이상일경우 중급,350만원 미만일 경우 초급이 뜨도록

--직원들의 모든 급여의 합을 구해라

--남자 사원들의 총 급여

--부서코드가 D5인 부서 사람들의 총 연봉

--사원들의 급여 평균값을 구하라

--사원들 중 이름의 값이 가장 작은 사람의 사원명,급여,입사일을 구하라

--사원들 중 이름의 값이 가장 큰 사람의 사원명,급여,입사일을 구하라

--전체 사원 수

--전체 여사원 수

--보너스를 받는 사원의 수

--현재 사원들이 총 몇 개의 부서에 분포되어 있는지를 구해라

--각 부서 별로 급여 총합
--그룹: 부서

--각 부서 별로 사원수

--각 직급별 총 사원 수, 보너스를 받은 사람 수, 급여합,평균 급여,최저급여,최고급여(정렬 = 직급 내림차순)

--남,여의 사원 수

--각 부서별 직급이 몇 개씩 있는지(GROUP BY절에 여러 컬럼을 기술할 수 있음)

--각 부서별 평균 급여(부서코드,평균급여)

--각 부서별 평균 급여가 300만원 이상인 부서들만 조회(부서코드,평균급여)

--직급별 직급코드, 총급여합(단, 직급별 총급여 합이 1000만원 이상인 직급만 조회)

--부서별 보너스를 받는 사원이 없는 부서의 부서코드

-------------------------------------------------------

/*
    SELECT* --5
    FROM 테이블  --1
    WHERE 조건식  --2
    GROUP BY 그룹의 기준이 되는 컬럼 | 함수식  --3
    HAVING 조건식 --4
    ORDER BY 정렬기준 컬럼 --6



*/

--전체 사원들의 사번, 사원명,부서코드,부서명

--1. 연결할 두 컬럼명이 다른 경우(EMPLOYEE: DEPT_CODE/ DEPARTMENT: DEPT_ID)
--전체 사원들의 사번,사원명,부서코드,부서명