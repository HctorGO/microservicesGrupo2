@Controller
public class HollaMundoCLIController {
	
	@GetMapping("/hello-word")
	@ResponseBody
	public String helloSpreingCLI() {
		return "Hola Mundo SB CLI"
	}
}