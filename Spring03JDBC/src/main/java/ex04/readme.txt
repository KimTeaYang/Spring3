ex03 패키지 수행 순서

Spring_MyBatis 실습 순서

[1] database.properties를 생성
 => src/main/resources/props에 만들어두기

[2] appContext.xml 파일 생성
 => (1) DataSource Bean 등록
    (2) SqlSessionFactory Bean 등록
    (3) SqlSessionTemplate Bean 등록
    (4) UserDAOMyBatis Bean 등록

[3] mybatis-config.xml 파일 생성
 => typeAlias 등록 => xxxMapper파일 등록

[4] UserMapper.xml 파일 생성
 => 쿼리문 등록
 
[5] UserDAOMyBatis 작성