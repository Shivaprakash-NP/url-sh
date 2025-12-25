package in.shiva.sh.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.shiva.sh.dto.URLReq;
import in.shiva.sh.dto.URLRes;
import in.shiva.sh.service.Urlservice;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UrlController {
    private final Urlservice service;

    @PostMapping("/shorten")
    public URLRes getUrl(@RequestBody URLReq body) {
        return service.getShort(body.getOriginalURL());
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> viewURL(@PathVariable String shortUrl) {
        URLRes obj =  service.getURL(shortUrl);

        if(obj != null) {
            return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(URI.create(obj.getOriginalURL())).build();
        }

        return ResponseEntity.notFound().build();
    }
}
