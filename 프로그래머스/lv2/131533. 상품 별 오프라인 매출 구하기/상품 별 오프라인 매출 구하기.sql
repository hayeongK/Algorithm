-- 코드를 입력하세요
SELECT a.product_code, a.price*sum(b.sales_amount)
from product a join offline_sale b on a.product_id = b.product_id
group by b.product_id 
order by a.price*sum(b.sales_amount) desc, a.product_code;