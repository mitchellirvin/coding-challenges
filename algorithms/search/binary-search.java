import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
	public int sqrt(int a) {
	    if(a <= 1) return a;
	    
	    BigDecimal power = new BigDecimal(a);
	    BigDecimal lower = new BigDecimal(1);
	    BigDecimal upper = power.divide(new BigDecimal(2));
	    BigDecimal root = new BigDecimal(0);

	    while(lower.compareTo(upper) != 1) {
	        BigDecimal mid = (lower.add(upper)).divide(new BigDecimal(2));
	        mid = mid.setScale(0, RoundingMode.UP);

	        if((mid.multiply(mid)).compareTo(power) == 0) return mid.intValueExact();
	        else if((mid.multiply(mid)).compareTo(power) == -1) {
	            lower = mid.add(BigDecimal.ONE);
	            root = mid;
	        } else upper = mid.subtract(BigDecimal.ONE);
	    }

	    return root.intValueExact();
	}
}
