package homecare.mega.config;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import homecare.mega.utils.MyConstant;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI()
    {
        return new OpenAPI()
        .info(new Info()
            .title(MyConstant.SWAGGER_INFO_TITLE)
            .description(MyConstant.SWAGGER_INFO_DESCRIPTION)
            .version(MyConstant.SWAGGER_INFO_VERSION)
            .contact(new Contact()
                    .name(MyConstant.SWAGGER_INFO_CONTACT_NAME)
                    .email(MyConstant.SWAGGER_INFO_CONTACT_EMAIL)
                    .url(MyConstant.SWAGGER_INFO_CONTACT_URL))
            .license(new License()
                    .name(MyConstant.SWAGGER_INFO_SWAGGER_INFO_LICENSE_NAME)
                    .url(MyConstant.SWAGGER_INFO_SWAGGER_INFO_LICENSE_URL)))
        .servers(List.of(new Server().url(MyConstant.JWT_LOCALHOST_URL)))
        .addSecurityItem(new SecurityRequirement().addList(MyConstant.JWT_SECURITY_SCHEME_NAME))
        .components(new Components().addSecuritySchemes(MyConstant.JWT_SECURITY_SCHEME_NAME,
                    new SecurityScheme()
                    .name(MyConstant.JWT_SECURITY_SCHEME_NAME)
                    .description(MyConstant.JWT_DESCRIPTION)
                    .bearerFormat(MyConstant.JWT_BEARER_FORMAT)
                    .scheme(MyConstant.JWT_SECURITY_SCHEME)
                    .type(SecurityScheme.Type.HTTP)));
    }
}
