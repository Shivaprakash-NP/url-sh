package in.shiva.sh.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.shiva.sh.dto.URLRes;
import in.shiva.sh.model.Url;
import in.shiva.sh.repository.UrlRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Urlservice {
    private final UrlRepository repo;
    private final String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public URLRes getShort(String url) {
        Optional<Url> obj = repo.findByOriginalUrl(url);

        if(obj.isPresent()) {
            Url existing = obj.get();
            return new URLRes(existing.getShortCode(), existing.getOriginalUrl(), existing.getCreatedAt());
        }

        Url newUrl = new Url();
        newUrl.setOriginalUrl(url);
        newUrl.setCreatedAt(LocalDateTime.now());
        newUrl.setShortCode("TEM");
        
        Url saved = repo.save(newUrl);

        String shortURL = getshortURL(saved.getId());
        saved.setShortCode(shortURL);

        repo.save(saved);

        return new URLRes(saved.getShortCode(), saved.getOriginalUrl(), saved.getCreatedAt());
    }

    private String getshortURL(Long n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            sb.append(base62.charAt(((int)(n%62))));
            n /= 62;
        }

        return sb.toString();
    }

    public URLRes getURL(String shortUrl) {
        Optional<Url> obj = repo.findByShortCode(shortUrl);
        if(obj.isPresent()) {
            Url newUrl = obj.get();
            return new URLRes(newUrl.getShortCode(), newUrl.getOriginalUrl(), newUrl.getCreatedAt());
        } 
        return null;
    }
}
