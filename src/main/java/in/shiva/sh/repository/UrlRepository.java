package in.shiva.sh.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shiva.sh.model.Url;


public interface UrlRepository extends JpaRepository<Url, Long>{
    //for finding Original URL
    Optional<Url> findByOriginalUrl(String originalUrl);

    //for finding short URL
    Optional<Url> findByShortCode(String shortCode);
}
