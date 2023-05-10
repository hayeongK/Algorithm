-- 코드를 입력하세요
SELECT hour(datetime) as 'HOUR', count(*) as 'COUNT' from animal_outs group by hour(datetime) having hour between 9 and 19 order by hour(datetime);