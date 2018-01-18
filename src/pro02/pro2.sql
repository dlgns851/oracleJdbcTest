/*
1)	평균 연봉(salary)이 가장 높은 나라는?
 */
select  co.country_name 지역이름,sb.av 평균연봉
from countries co, ( select   lo.country_id,avg(su) av
from  locations lo, (select location_id,avg(su) su
                    from departments de,   (select department_id,avg(salary) su
                                            from employees
                                            group by department_id) sb 

                    where de.department_id=sb.department_id
                    group by location_id) sb
where lo.location_id=sb.location_id
group by lo.COUNTRY_ID) sb
where sb.country_id = co.country_id
      and sb.av = (select max(sb.av)
from (
select   lo.country_id,avg(su) av
from  locations lo, (select location_id,avg(su) su
                    from departments de,   (select department_id,avg(salary) su
                                            from employees
                                            group by department_id) sb 

                    where de.department_id=sb.department_id
                    group by location_id) sb
where lo.location_id=sb.location_id
group by lo.COUNTRY_ID )sb)

/*
2)	평균 연봉(salary)이 가장 높은 지역은?
*/
select re.REGION_NAME 지역이름, sb.av 평균연봉
from regions re,(

select co.REGION_ID,avg(av) av
from countries co ,(select   lo.country_id,avg(su) av
from  locations lo, (select location_id,avg(su) su
                    from departments de,   (select department_id,avg(salary) su
                                            from employees
                                            group by department_id) sb 

                    where de.department_id=sb.department_id
                    group by location_id) sb
                    where lo.location_id=sb.location_id
                    group by lo.COUNTRY_ID) sb

where co.country_id=sb.country_id
group by co.REGION_ID) sb
where sb.region_id=re.region_id 
   
     AND av=(select max(sb.av) 
from (select co.REGION_ID,avg(av) av
     from countries co ,(select   lo.country_id,avg(su) av
                        from  locations lo, (select location_id,avg(su) su
                                            from departments de,   (select department_id,avg(salary) su
                                                                  from employees
                                                                     group by department_id) sb 

                    where de.department_id=sb.department_id
                    group by location_id) sb
                    where lo.location_id=sb.location_id
                    group by lo.COUNTRY_ID) sb

where co.country_id=sb.country_id
group by co.REGION_ID) sb)


/*
3)	가장 많은 직원이 있는 부서는 어떤 부서인가요?
*/
select department_name 부서이름, sb.co 직원수
from (select de.department_name,count(*) co
	  from employees em , departments de
	  where em.department_id=de.department_id
	  group by de.department_name)sb
where sb.co= (select max(sb.co) ma
			  from (select de.department_name,count(*) co
			  		from employees em , departments de
					where em.department_id=de.department_id
					group by de.department_name) sb);
