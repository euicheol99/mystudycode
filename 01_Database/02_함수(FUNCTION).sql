SELECT EMP_ID,EMP_NAME,SALARY  --3
FROM EMPLOYEE                  --1
WHERE DEPT_CODE='D2';          --2

--1,2,3은 실행 순서 

/*

        <ORDER BY절>
        SELECT문 가장 마지막 줄에 작성, 상행순서또한 가장 마지막에 실행한다.
        
        [표현법]
        SELECT 조회할 컬럼...
        FROM 조회할 테이블
        WHERE 조건식
        ORDER BY 정렬기준이 될 컬럼명 | 별칭 | 컬럼순번 [ASC | DESC] [NULLS FIRST | NULLS LAST]
        
        --ASC: 오름차순(작은 값으로 시작해서 점점 커지는 것) --> 기본값
        --DESC: 내림차순(큰 값으로 시작해서 값이 점점 줄어드는 것)
        
        --NULL은 기본적으로 가장 큰 값으로 분류해서 정렬한다.
        --NULLS FIRST: 정렬하고자 하는 컬럼값에 NULL이 있을 경우 해당 데이터 맨 앞에 배치 (DESC일 때 기본값)
        --NULLS LAST: 정렬하고자 하는 컬럼값에 NULL이 있을 경우 해당 데이터 맨 뒤에 배치 (ASC일 때 기본값)
*/

SELECT *
FROM EMPLOYEE
--ORDER BY BONUS;
--ORDER BY BONUS ASC;
--ODDER BY BONUS ASC NULLS FIRST;
--ORDER BY BONUS DESC; --NULLS FIRST가 기본값으로 적용
--정렬기준에 컬럼같이 동일할 경우 그 다음차순을 위해서 여러개를 제시할 수 있다.
ORDER BY BONUS DESC, SALARY ASC;

--전 사원의 사원명, 연봉 조회(이 때 연봉을 기준으로 내림차순 정렬)
SELECT EMP_NAME,SALARY*12 연봉
FROM EMPLOYEE
--ORDER BY SALARY*12 DESC;
--ORDER BY 연봉 DESC;
ORDER BY 2 DESC;

--------------------------------------------------------
/*

        <함수 FUNCTION>
        전달된 컬럼값을 읽어들여서 함수를 실행한 결과를 반환
        
        -단일행 함수: N개의 값을 읽어들여서 N개의 결과값을 리턴(매행마다 함수실행결과를 반환)
        -그룹함수: N개의 값을 읽어들여서 1개의 결과값을 리턴(그룹을 지어 그룹별로 함수 실행결과를 반환)
        
        >>SELECT절에 단일행 함수와 그룹함수를 함께 사용하지 못 한다.
        왜? 결과 행의 갯수가 서로 다르기 때문에
        
        >>함수식을 사용할 수 있는 위치: SELECT절,WHERE절,ORDER BY절,GROUP BY절,HAVING 절
        
*/

---------------------------------단일행 함수------------------------------

/*

        <문자 처리 함수>
        *LENGTH(컬럼 | '문자열'): 해당 문자열의 글자수를 반환
        *LENGTHB(컬럼 | '문자열'): 해당 문자열의 바이트수를 반환
        
        '최' '나' 'ㄱ' 한글은 글자당 3BYTE
        영문자, 숫자, 특수문자 글자당 1BYTE
        
*/

SELECT LENGTH('오라클'), LENGTHB('오라클')
FROM DUAL;

SELECT LENGTH('ORACLE'), LENGTHB('ORACLE')
FROM DUAL;

SELECT EMP_NAME,LENGTH(EMP_NAME), LENGTHB(EMP_NAME),
    EMAIL, LENGTH(EMAIL), LENGTHB(EMAIL)
FROM EMPLOYEE;
        
/*

        *INSTR
        문자열로부터 특정 문자의 시작위치를 찾아서 변환
        
        INSTR(컬럼 | '문자열', '찾고자하는 문자', '찾을 위치의 시작값', 순번1)-> 결과는 NUMBER로 나옴
        
*/

SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL;
--찾을 위치의 시작값 : 1,순번:1-->기본값
SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B',1,2) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B',1,3) FROM DUAL;
SELECT EMAIL, INSTR(EMAIL, '_') AS "LOCATION", INSTR(EMAIL,'@') AS "@위치"
FROM EMPLOYEE;

--------------------------------------------

/*

        *SUBSTR / 자주 사용
        문자열에서 특정 문자열을 추출해서 반환
        
        [표현법]
        SUBSTR(컬럼 | '문자열', 추출할 시작위치, 추출문자 갯수)
        
*/
SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 5,2) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 1,6) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', -8,3) FROM DUAL;

SELECT EMP_NAME, EMP_NO,SUBSTR(EMP_NO, 8,1) AS 성별
FROM EMPLOYEE;

--사원들 중 여사원들만 EMP_NAME, EMP_NO를 조회
SELECT EMP_NAME,EMP_NO
FROM EMPLOYEE
WHERE SUBSTR (EMP_NO, 8,1)=2 OR SUBSTR (EMP_NO,8,1)=4;
--사원들 중 남사원들만 EMP_NAME, EMP_NO를 조회
SELECT EMP_NAME,EMP_NO
FROM EMPLOYEE
WHERE SUBSTR (EMP_NO, 8,1)=1 OR SUBSTR (EMP_NO,8,1)=3;


--함수 중첩사용 가능
--이메일 아이디 부분만 추출
--사원목록에서 사원명,이메일,이메일 아이디 조회
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1 ,INSTR(EMAIL, '@')-1)
FROM EMPLOYEE;

-------------------------------------------------------------------

/*

        *LPAD / RPAD
        문자열을 조회할 때 통일감있게 조회하고자 할 때 사용
        
        [표현법]
        LPAD/RPAD(STRING, 최정적으로 반환할 문자열의 길이, [덧붙이고자하는 문자])
*/

--30만큼의 길이 중 EMAIL컬럼값은 오른쪽으로 정렬하고 나머지 부분은 공백으로 채운다.
SELECT EMP_NAME, LPAD(EMAIL, 30)
FROM EMPLOYEE;

SELECT EMP_NAME, LPAD(EMAIL, 30, '#')
FROM EMPLOYEE;  

SELECT EMP_NAME, RPAD(EMAIL, 30, '#')
FROM EMPLOYEE;

--사원들의 사원명,주민등록번호("123456-1XXXXXX")로 조회
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1,8), 14, 'X')
FROM EMPLOYEE;
--또는
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1,8), 14, 'XXXXXX')
FROM EMPLOYEE;

-------------------------------------------------------------------
/*

        *LTRIM/RTRIM
        문자열에서 특정 문자를 제거한 나머지를 반환
        LTRIM/RTRIM(컬럼 | '문자열', [제거하고자하는 문자들])
        
        문자열의 왼쪽 혹은 오른쪽에서 제거하고자 하는 문자들을 찾아서 제거한 나머지 문자열 반환
*/

SELECT LTRIM('   K  H  ') FROM DUAL;   --앞에서부터 다른 문자가 나올 때 까지 공백제거
SELECT LTRIM('123123KH123','123') FROM DUAL;
SELECT LTRIM('ACABACCAKH','ABC') FROM DUAL; --제거하고자 하는 문자는 문자열이 아닌 '문자들'

/*

    *TRIM
    문자열의 앞/뒤/양쪽에 있는 저장한 문자들을 제거한 나머지 문자열 변환
    TRIM([LEADING | TRAILING | BOTH] 제거하고자하는 문자열 FROM 문자열)
    
*/

SELECT TRIM('     K   H   ') FROM DUAL;
SELECT TRIM(BOTH 'Z' FROM 'ZZZZKHZZZZZZ') FROM DUAL; --양쪽
SELECT TRIM(LEADING 'Z' FROM 'ZZZZKHZZZZZZ') FROM DUAL; --LTRIM유사
SELECT TRIM(TRAILING 'Z' FROM 'ZZZZKHZZZZZZ') FROM DUAL; --RTRIM유사

------------------------------------------------------------------------------
/*
        *LOWER /UPPER / INITCAP
        LOWER : 다 소문자로 변경한 문자열 반환
        UPPER : 다 대문자로 변경한 문자열 반환
        INITCAP: 띄어쓰기 기준 첫 글자마다 대문자로 변경한 문자열 반환
        
*/

SELECT LOWER('welcome To my KH') FROM DUAL;
SELECT UPPER('welcome To my KH') FROM DUAL;
SELECT INITCAP('welcome To my KH') FROM DUAL;


/*
    *CONCAT
    문자열 두 개 전달받아서 하나로 합친 후 반환
    CONCAT (STRING1,STRING2)
*/

SELECT CONCAT('가나다','ABC') FROM DUAL;
SELECT '가나다' || 'ABC' FROM DUAL;

--------------------------------------------------------------------------
/*
    *REPLACE
    특정문자열에서 특정부분을 다른 부분으로 교체
    REPLACE(문자열, 찾을 문자열, 변경할 문자열)
*/

SELECT EMAIL,REPLACE(EMAIL,'C##SERVER', 'KH')
FROM EMPLOYEE;


----------------------------------------------------------------------------
/*
    <숫자처리함수>
    *ABS
    숫자의 절대값을 구하는 함수
*/

SELECT ABS(-10), ABS(-5.4) FROM DUAL;

--------------------------------------------------------------------------
/*

    *MOD
    두 수를 나눈 나머지 값을 반환
    MOD(NUMBER, NUMBER)
*/

SELECT MOD(10,3) FROM DUAL;
SELECT MOD(10.9,3) FROM DUAL;

--------------------------------------------------------------------------
/*

    *ROUND
    반올림한 결과를 반환
    ROUND(NUMBER, [위치])
*/

SELECT ROUND(123.456) FROM DUAL;  --기본 차수는 소수점 첫번째 자리에서 반올림
SELECT ROUND(123.456,1) FROM DUAL; --양수로 증가할수록 소수점 뒤로 한 칸 씩 이동
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

/*

    <날짜 처리 함수>
    
*/

-- *SYSDATE : 시스템의 현재 날짜 및 시간을 반환(현재 내 컴퓨터 시간)
SELECT SYSDATE FROM DUAL;

--*MONTHS_BETWEEN : 두 날짜 사이의 개월 수
--사원들의 사원명,입사일,근무일수,근무개월수를 조회
SELECT EMP_NAME,HIRE_DATE,FLOOR(SYSDATE-HIRE_DATE),CEIL (MONTHS_BETWEEN (SYSDATE, HIRE_DATE))
FROM EMPLOYEE;

--*ADD_MONTHS: 특정 날짜에 NUMBER개월 수를 더해서 반환
SELECT ADD_MONTHS(SYSDATE,7) FROM DUAL;

--사원테이블에서 사원명,입사일,수습기간 종료일(+3개월)을 조회
SELECT EMP_NAME,HIRE_DATE, ADD_MONTHS(HIRE_DATE,3)
FROM EMPLOYEE;

--*NEXT_DAY(DATE,요일(문자|숫자)): 특정날짜 이후 가장 가까운 요일의 날짜를 반환
SELECT NEXT_DAY(SYSDATE,'토요일') FROM DUAL;
SELECT NEXT_DAY(SYSDATE,'토') FROM DUAL;


--1:일~7:토
SELECT NEXT_DAY(SYSDATE,7) FROM DUAL;

ALTER SESSION SET NLS_LANGUAGE=KOREAN;

--*LAST_DAY(DATE): 해당월의 마지막 날짜 구해서 반환
SELECT LAST_DAY(SYSDATE) FROM DUAL;

/*

    *EXTRACT: 특정 날짜로부터 년|월|일 값을 추출해서 반환하는 함수
    [표현법]
    EXTRACT(YEAR FROM DATE): 연도만 추출
    EXTRACT(MONTH FROM DATE): 월만 추출
    EXTRACT(DAY FROM DATE): 일만 추출
*/

--사원의 사원명, 입사년도, 입사월, 입사일 조회
SELECT EMP_NAME,
       EXTRACT(YEAR FROM HIRE_DATE) AS "입사년도",
       EXTRACT(MONTH FROM HIRE_DATE) AS "입사년도",
       EXTRACT(DAY FROM HIRE_DATE) AS "입사년도"
    FROM EMPLOYEE;
    
------------------------------
/*

    <형변환 함수>
    *TO_CHAR : 숫자타입 또는 날짜타입의 값을 문자타입으로 변환시켜주는 함수
    
    [표현법]
    TO_CHAR(숫자 | 문자, [포멧])

*/

--숫자 ->  문자
SELECT TO_CHAR(1234) FROM DUAL;

SELECT TO_CHAR(12,'99999') FROM DUAL; --9의 자리수만큼 공간을 확보
SELECT TO_CHAR(12,'00000') FROM DUAL; --0의 자리수만큼 공간확보, 빈칸을 0으로 채움
SELECT TO_CHAR(2000000,'L9999999') FROM DUAL; --현재 설정된 나라의 로컬 화폐단위 나타냄
SELECT TO_CHAR(2000000,'9,999,999') FROM DUAL;

--날짜타입 --> 문자타입 (수정에서 확인가능)
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE,' AM HH:MI:SS') FROM DUAL;  --AM,PM 어떤 것을 사용하건 형식을 정해주는 것
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY DY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY"년"-MM"월"-DD"일" HH"시"MM"분"SS"초"') FROM DUAL;

--사원들의 이름, 입사날짜 (0000년 00월 00일) 조회
SELECT EMP_NAME,TO_CHAR(HIRE_DATE, 'YYYY"년"MM"월"DD"일"')
FROM EMPLOYEE;

--년도와 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'YYYY'),
       TO_CHAR(SYSDATE, 'YY'),
       TO_CHAR(SYSDATE, 'YEAR'),
       TO_CHAR(SYSDATE, 'RRRR')
    FROM DUAL;
    
SELECT
    TO_CHAR(TO_DATE('24', 'RRRR'), 'YYYY'),
    TO_CHAR(TO_DATE('60', 'RRRR'), 'YYYY'),
    TO_CHAR(TO_DATE('2024', 'YYYY'), 'YYYY'),
    TO_CHAR(TO_DATE('1960', 'YYYY'), 'YYYY')
    FROM DUAL;
    
--월과 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'MM'),
        TO_CHAR(SYSDATE, 'MON'),
        TO_CHAR(SYSDATE, 'MONTH')
FROM DUAL;

--일에 관련된 포맷
SELECT TO_CHAR(SYSDATE,'DDD') --오늘이 이번년도에 몇번째 일수인지
       TO_CHAR(SYSDATE, 'DD'), -- 오늘일자
       TO_CHAR(SYSDATE, 'D') --요일
FROM DUAL;

--요일을 나타내는 포맷
SELECT TO_CHAR(SYSDATE, 'DAY'),
       TO_CHAR(SYSDATE, 'DY')
FROM DUAL;

/*
    TO_DATE : 숫자타입 또는 문자타입을 날짜타입으로 변경하는 함수
    
    TO_DATE(숫자 | 문자, [포맷]) -> DATE

*/

SELECT TO_DATE(20100101) FROM DUAL;
SELECT TO_DATE(611218) FROM DUAL; --기본적으로 연도를 2자리만 입력시 RR룰이 적용된다.

SELECT TO_DATE(051010) FROM DUAL; --0으로 시작하는 숫자는 없다.(오류)
SELECT TO_DATE('051010') FROM DUAL;

SELECT TO_DATE('020505 120500') FROM DUAL; --포맷을 정해주게 되어있음.
SELECT TO_DATE('020505 230500', 'YYMMDD HH24MISS') FROM DUAL;

-----------------

/*
    TO_NUMBER : 문자타입의 데이터를 숫자타입으로 변환시켜주는 함수
    
    [표현법]
    TO_NUMBER(문자,[포맷])
*/

SELECT TO_NUMBER('065431642511') FROM DUAL;

SELECT '1000' + '3000' FROM DUAL; --문자열 -> 숫자로 자동형변환이 진행된다.
SELECT TO_NUMBER ('100,000','999,999') + TO_NUMBER('30,000','99,999') FROM DUAL;

/*

    [NULL처리 함수]
*/

--*NVL(컬럼,해당컬럼이 NULL일 경우 보여줄 값)
SELECT EMP_NAME, NVL(BONUS, 0)
FROM EMPLOYEE;

--전 사원의 이름, 보너스 포함 연봉 조회
SELECT EMP_NAME, (SALARY+(SALARY * NVL(BONUS,0)))*12
FROM EMPLOYEE;

--*NVL2(컬럼, 반환값1,반환값2)
--반환값1 : 해당컬럼이 존재하면 보여줄 값
--반환값2 : 해당컬럼이 존재하지 않으면 보여줄 값
--사원들의 보너스가 있는지 없는지 나타내기
SELECT EMP_NAME,BONUS,NVL2(BONUS, 'O','X')
FROM EMPLOYEE;

--* NULLIF(비교대상1,비교대상2)
--두 값이 일치하면 NULL, 일치하지 않으면 비교대상1 반환
SELECT NULLIF('123', '123') FROM DUAL;
SELECT NULLIF('123', '456') FROM DUAL;

------------------

/*
    [선택함수]
    #DECODE(비교하고자하는 대상, 비교값1, 결과값1, 비교값2, 결과값2..)
    
*/

--사번,사원명,주민등록번호,성별
SELECT EMP_ID,EMP_NAME,EMP_NO,
        DECODE (SUBSTR(EMP_NO,8,1),'1','남','2','여','3','남','4','여')
FROM EMPLOYEE;

--직원의 성명, 기존급여,인상된 급여 조회(각 직급별로 차등인상)
--J7직급은 급여를 10%인상(SALARY*1.1)
--J6직급은 급여를 15%인상(SALARY*1.15)
--J5직급은 급여를 20%인상(SALARY*1.2)
--그 외 직급은 급여를 5%인상(SALARY*1.05)
SELECT EMP_NAME,JOB_CODE,SALARY,
DECODE (JOB_CODE,
        'J7',SALARY*1.1,
        'J6',SALARY*1.15,
        'J5',SALARY*1.2,
        SALARY*1.05)
FROM EMPLOYEE;








SELECT EMP_NAME,SALARY,
        DECODE (JOB_CODE,
        'J7',(SALARY*1.1),
        'J6',(SALARY*1.15),
        'J5',(SALARY*1.2),
        SALARY*1.05) AS " 인상 후"
FROM EMPLOYEE;

/*
    *CASE WHEN THEN
    CASE
        WHEN 조건식1 THEN 결과값1
        WHEN 조건식2 THEN 결과값2
        ...
        ELSE 결과값
        
    END
*/

--사원명,급여를 조회하고 500만원 이상일 경우 고급,350만원 이상일경우 중급,350만원 미만일 경우 초급이 뜨도록
SELECT EMP_NAME,SALARY,
        CASE
            WHEN SALARY >= 5000000 THEN '고급'
            WHEN SALARY >= 3500000 THEN '중급'
            ELSE '초급'
        END
FROM EMPLOYEE;

-------------------------------
--1.SUM(숫자타입컬럼) :해당컬럼값들의 총 합계를 구해서 반환해주는 함수

--직원들의 모든 급여의 합을 구해라
SELECT SUM(SALARY)
FROM EMPLOYEE;

--남자 사원들의 총 급여
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)IN ('1','3');


--부서코드가 D5인 부서 사람들의 총 연봉
SELECT SUM(SALARY*12)
FROM EMPLOYEE
WHERE DEPT_CODE ='D5';

--2. AVG(NUMBER): 해당 컬럼값들의 평균을 구해서 변환
SELECT AVG(SALARY)
FROM EMPLOYEE;

--3. MIN(모든 타입 가능): 해당 컬럼 값 중 가장 작은 값을 구해서 변환
SELECT MIN(EMP_NAME), MIN(SALARY), MIN(HIRE_DATE)
FROM EMPLOYEE;

--4. MAX(모든 타입 가능): 해당 컬럼 값 중 가장 큰 값을 구해서 변환
SELECT MAX(EMP_NAME), MAX(SALARY), MAX(HIRE_DATE)
FROM EMPLOYEE;

--5. COUNT(* | 컬럼 | DISTINCT 컬럼) : 해당 조건에 맞는 행의 갯수를 세서 반환
--COUNT(*) : 조회된 결과에 모든 행의 갯수를 세서 반환
--COUNT(컬럼): 제시한 해당 컬럼값이 NULL이 아닌 것만 행의 수를 세서 반환
--COUNT(DISTINCT 컬럼) : 해당 컬럼값 중복을 제거한 후 행의 갯수를 세서 반환

--전체 사원 수
SELECT COUNT(*) FROM EMPLOYEE;

--전체 여사원 수
SELECT COUNT(*)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) IN ('2','4');

--보너스를 받는 사원의 수
SELECT COUNT(BONUS)
FROM EMPLOYEE;

SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

--현재 사원들이 총 몇 개의 부서에 분포되어 있는지를 구해라
SELECT COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;