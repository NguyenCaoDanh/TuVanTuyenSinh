/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Comment;
import com.tqh.pojo.Post;
import com.tqh.service.AdmissionService;
import com.tqh.service.CommentService;
import com.tqh.service.FacultyService;
import com.tqh.service.PostService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiPostController {

    @Autowired
    private PostService postService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private AdmissionService admissionService;
    @Autowired
    private CommentService commentService;

    @DeleteMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.postService.deletePost(id);
    }

    
    @RequestMapping("/posts/")
    @CrossOrigin
    public ResponseEntity<List<Post>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.postService.getPosts(params), HttpStatus.OK);
    }

    @RequestMapping(path = "/posts/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Post> details(@PathVariable(value = "id") int id) {
    return new ResponseEntity<>(this.postService.getPostById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/posts", consumes = {
        MediaType.MULTIPART_FORM_DATA_VALUE,
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
        Post p = new Post();
        p.setPostName(params.get("name"));
        p.setPostinformation(params.get("information"));
        p.setPosttype(params.get("type"));
        p.setPostImg(params.get("image"));
        p.setAdmissionIdadmission(this.admissionService.getAdmissionById(Integer.parseInt(params.get("admissionId"))));
        if (file.length > 0) {
            p.setFile(file[0]);
        }
        this.postService.addOrUpdatePost(p);
    }

    @GetMapping("/posts/{id}/comments/")
    public ResponseEntity<List<Comment>> listComments(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.commentService.getComments(params), HttpStatus.OK);
    }

//    @PostMapping(path="/comments/", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Boolean> addComment(@RequestBody Boolean comment) {
//        Comment c = this.commentService.addComment(true);        
//        return new ResponseEntity<>(c, HttpStatus.CREATED);
//    }
}
