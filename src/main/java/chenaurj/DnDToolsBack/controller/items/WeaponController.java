package chenaurj.DnDToolsBack.controller.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import chenaurj.DnDToolsBack.model.items.Weapon;
import chenaurj.DnDToolsBack.service.items.WeaponService;

@Controller
public class WeaponController {

	@Autowired
	private WeaponService weaponService;
	
	@RequestMapping(value = "/weapon", method = RequestMethod.POST)
	public @ResponseBody Weapon createWeapon(@RequestBody Weapon weapon) {
		return weaponService.createWeapon(weapon);
	}
	
	@RequestMapping(value = "/weapon/{id}", method = RequestMethod.GET)
	public @ResponseBody Weapon getWeapon(@PathVariable(value = "id") String id) {
		return weaponService.getWeapon(id);
	}
	
}
