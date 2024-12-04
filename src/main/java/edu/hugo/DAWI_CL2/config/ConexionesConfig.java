package edu.hugo.DAWI_CL2.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConexionesConfig {

    @Value("${DB_WORLD_URL}")
    private String dbSakilaUrl;
    @Value("${DB_ WORLD_USER}")
    private String dbSakilaUser;
    @Value("${DB_ WORLD_PASS}")
    private String dbSakilaPass;
    @Value("${DB_ WORLD_DRIVER}")
    private String dbSakilaDriver;

    @Bean
    public HikariDataSource hikariDataSource() {

        HikariConfig config = new HikariConfig();

        /**
         * Configurar propiedad de conexion a BD
         */
        config.setJdbcUrl(dbSakilaUrl);
        config.setUsername(dbSakilaUser);
        config.setPassword(dbSakilaPass);
        config.setDriverClassName(dbSakilaDriver);

        /**
         * Configurar propiedades del pool de HikariCP
         * - MaximumPoolSize: Máximo # de conexiones del pool.
         * - MinimumIdle: Mínimo # de conexiones inactivas del pool.
         * - IdleTimeout: Tiempo máximo de espera para
         *      eliminar una conexión inactiva.
         * - ConnectionTimeout: Tiempo máximo de espera
         *      para conectarse a la BD.
         */
        config.setMaximumPoolSize(30); // cantidad de personas que se conectan al mismo tiempo
        config.setMinimumIdle(4); //inactivos
        config.setIdleTimeout(240000); // 4 minutos en milisegundosw
        config.setConnectionTimeout(45000); //tiempo de conexion 45 segundos

        System.out.println("###### HikariCP initialized ######");
        return new HikariDataSource(config);

    }

}
