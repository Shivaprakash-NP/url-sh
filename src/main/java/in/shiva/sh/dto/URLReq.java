package in.shiva.sh.dto;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class URLReq {
    @URL(message = "Provide a valid URL")
    @NotBlank(message = "Provide a URL")
    private String originalURL;
}