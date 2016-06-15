package fr.djoutsop.berangere.planner.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.djoutsop.berangere.planner.controller.util.HeaderUtil;
import fr.djoutsop.berangere.planner.controller.util.PaginationUtil;
import fr.djoutsop.berangere.planner.entity.Schedule;
import fr.djoutsop.berangere.planner.repository.ScheduleRepository;

@RestController
@RequestMapping("/api")
public class SourceResource {

    private final Logger log = LoggerFactory.getLogger(SourceResource.class);

    @Inject
    private ScheduleRepository sourceRepository;

//    @RequestMapping(value = "/sources",
//        method = RequestMethod.POST,
//        produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> createUser(@RequestBody Schedule source, HttpServletRequest request) throws URISyntaxException {
//        log.debug("REST request to save Source : {}", source);
//
//        if (sourceRepository.findOneByName(source.getName()).isPresent()) {
//            return ResponseEntity.badRequest()
//                .headers(HeaderUtil.createFailureAlert("sourceManagement", "nameexists", "name already in use"))
//                .body(null);
//        } else {
//        	Schedule newSource = sourceRepository.saveAndFlush(source);
//            return ResponseEntity.created(new URI("/api/sources/" + newSource.getId()))
//                .headers(HeaderUtil.createAlert( "sourceManagement.created", newSource.getName()))
//                .body(newSource);
//        }
//    }
//
//    @RequestMapping(value = "/sources",
//        method = RequestMethod.PUT,
//        produces = MediaType.APPLICATION_JSON_VALUE)
//    @Transactional
//    public ResponseEntity<Schedule> updateUser(@RequestBody Schedule source) {
//        log.debug("REST request to update Source : {}", source);
//        Optional<Schedule> existingSource = sourceRepository.findOneByName(source.getName());
//        if (existingSource.isPresent() && (!existingSource.get().getId().equals(source.getId()))) {
//            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("sourceManagement", "nameexists", "name already in use")).body(null);
//        }
//        return sourceRepository
//            .findOneById(source.getId())
//            .map(sourceToUpdate -> {
//                sourceToUpdate.setName(source.getName());
//                sourceToUpdate.setUrl(source.getUrl());
//                return ResponseEntity.ok()
//                    .headers(HeaderUtil.createAlert("sourceManagement.updated", source.getName()))
//                    .body(sourceRepository
//                        .findOne(source.getId()));
//            })
//            .orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
//
//    }
//
//    @RequestMapping(value = "/sources",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Transactional(readOnly = true)
//    public ResponseEntity<List<Schedule>> getAllSources(Pageable pageable)
//        throws URISyntaxException {
//        Page<Schedule> page = sourceRepository.findAll(pageable);
//        List<Schedule> sources = page.getContent().stream()
//            .collect(Collectors.toList());
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sources");
//        return new ResponseEntity<>(sources, headers, HttpStatus.OK);
//    }
//    
//    @RequestMapping(value = "/source/{id}",
//        method = RequestMethod.GET,
//        produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Schedule> getSource(@PathVariable Long id) {
//        log.debug("REST request to get Source : {}", id);
//        return sourceRepository.findOneById(id)
//                .map(source -> new ResponseEntity<>(source, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @RequestMapping(value = "/source/{id}",
//        method = RequestMethod.DELETE,
//        produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> deleteSource(@PathVariable Long id) {
//        log.debug("REST request to delete Source: {}", id);
//        return sourceRepository.findOneById(id)
//                .map(source -> {
//                	sourceRepository.delete(source);
//                	return ResponseEntity.ok().headers(HeaderUtil.createAlert( "sourceManagement.deleted", source.getName())).build();	
//                })
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
}
