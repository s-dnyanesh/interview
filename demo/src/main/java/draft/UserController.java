package draft;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/web")
public class UserController {
	String url="https://localhost:8080/web/order/1001/receipts?date=2021-12-21";
	@GetMapping("/order/{date}")
	public void getData(@RequestParam String date){
		System.out.println("date"+date);
		
	}
	
}
