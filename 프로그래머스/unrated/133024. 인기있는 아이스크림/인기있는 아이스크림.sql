-- 코드를 입력하세요
SELECT flavor from first_half group by flavor order by sum(total_order) desc, shipment_id;