package co.com.munamu.munamuinventory.initializer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.munamu.munamuinventory.data.dao.GenreDAO;
import co.com.munamu.munamuinventory.data.dao.impl.sql.sqlserver.GenreSqlServerDAO;
import co.com.munamu.munamuinventory.dto.GenreDTO;

@RestController
@RequestMapping("/miservicio/generos")
public class Service {
	
	private GenreSqlServerDAO genreService;

}
