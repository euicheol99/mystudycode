<DISTINCT>
중복제거-컬럼에 표시된 값들을 한 번씩만 조회하고 할 때 사용
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

--WHERE EMAIL LIKE '____%'; ->  _와 %는 와일드카드로 인식되기 때문에 정상적으로 출력할 수 없다.
--와일드카드와 일반문자를 구분해줘야한다.
--데이터값으로 취급하고싶은 와일드카드 문자 앞에 나만의 탈출문자를 제시해서 탈출시켜주면된다.
--ESCAPE OPTION을 등록해서 사용

--앞에 3글자가 있고,네번째 글자에 '_'가 있는 이메일을 추출하시오
WHERE EMAIL LIKE '___/_%' ESCAPE '/'; --'/'를 ESCAPE 문자로 사용

*INSTR
문자열로부터 특정 문자의 시작위치를 찾아서 변환
INSTR(컬럼 또는 '문자열', '찾고자하는 문자', '찾을 위치의 시작값', 순번1)-> 결과는 NUMBER로 나옴

*LPAD / RPAD
문자열을 조회할 때 통일감있게 조회하고자 할 때 사용
LPAD/RPAD(STRING, 최정적으로 반환할 문자열의 길이, [덧붙이고자하는 문자])

--30만큼의 길이 중 EMAIL컬럼값은 오른쪽으로 정렬하고 나머지 부분은 공백으로 채운다.
SELECT EMP_NAME, LPAD(EMAIL, 30)
FROM EMPLOYEE;

--30만큼의 길이 중 EMAIL컬럼값은 오른쪽으로 정렬하고 나머지 부분은 '#'으로 채운다.
SELECT EMP_NAME, LPAD(EMAIL, 30, '#')
FROM EMPLOYEE;  