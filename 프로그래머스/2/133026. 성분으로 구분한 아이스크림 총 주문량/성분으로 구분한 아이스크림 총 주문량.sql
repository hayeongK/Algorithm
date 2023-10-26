select ingredient_type, sum(f.total_order) as TOTAL_ORDER
from first_half as f join icecream_info as i on f.flavor = i.flavor 
group by ingredient_type
order by TOTAL_ORDER;
