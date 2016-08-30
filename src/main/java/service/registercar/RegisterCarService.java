package service.registercar;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class RegisterCarService {
	
	public @ResponseBody RegisterCarResponse registerCar(@RequestBody RegisterCarRequest registerCarRequest) {
		return null;
		
	}

}
