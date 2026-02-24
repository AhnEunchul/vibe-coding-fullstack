package com.example.vibeapp.post;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import jakarta.validation.Valid;

import org.springframework.validation.BindingResult;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String listPosts(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        int pageSize = 5;
        int totalCount = postService.getTotalCount();
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);

        model.addAttribute("posts", postService.getPosts(page, pageSize));
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalCount", totalCount);
        
        return "post/posts";
    }

    @GetMapping("/posts/{no}")
    public String getPostDetail(@PathVariable("no") Long no, Model model) {
        model.addAttribute("post", postService.findById(no));
        return "post/post_detail";
    }

    @GetMapping("/posts/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new PostCreateDto());
        return "post/post_new_form";
    }

    @PostMapping("/posts/add")
    public String createPost(@Valid @ModelAttribute("post") PostCreateDto createDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "post/post_new_form";
        }
        postService.createPost(createDto);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{no}/edit")
    public String editPostForm(@PathVariable("no") Long no, Model model) {
        PostResponseDto post = postService.findById(no);
        model.addAttribute("post", post);
        return "post/post_edit_form";
    }

    @PostMapping("/posts/{no}/save")
    public String updatePost(@PathVariable("no") Long no, @Valid @ModelAttribute("post") PostUpdateDto updateDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("post", postService.findById(no)); // To keep existing info if needed, or we should re-map DTO to model
            return "post/post_edit_form";
        }
        postService.updatePost(no, updateDto);
        return "redirect:/posts/" + no;
    }

    @GetMapping("/posts/{no}/delete")
    public String deletePost(@PathVariable("no") Long no) {
        postService.deletePost(no);
        return "redirect:/posts";
    }
}
