-- 코드를 입력하세요
SELECT left(product_code, 2) as 'pc', count(*) from product group by pc order by pc;