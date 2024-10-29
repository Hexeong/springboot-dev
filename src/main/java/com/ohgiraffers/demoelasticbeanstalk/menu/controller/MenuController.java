package com.ohgiraffers.demoelasticbeanstalk.menu.controller;

import com.ohgiraffers.demoelasticbeanstalk.menu.dto.MenuDto;
import com.ohgiraffers.demoelasticbeanstalk.menu.entity.Menu;
import com.ohgiraffers.demoelasticbeanstalk.menu.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // 메뉴 등록
    @PostMapping
    public ResponseEntity<Menu> registerMenu(@RequestBody MenuDto menuDto) {
        Menu createdMenu = menuService.registerMenu(menuDto);
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
    }

    // 메뉴 조회 by ID
    @GetMapping("/{menuCode}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Integer menuCode) {
        Menu menu = menuService.findById(menuCode);
        return menu != null ? new ResponseEntity<>(menu, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // 메뉴 수정
    @PutMapping("/{menuCode}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Integer menuCode, @RequestBody MenuDto menuDto) {
        menuDto.setMenuCode(menuCode); // Ensure the menuCode in DTO matches the path variable
        try {
            Menu updatedMenu = menuService.updateMenu(menuDto);
            return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 메뉴 삭제
    @DeleteMapping("/{menuCode}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Integer menuCode) {
        menuService.deleteMenu(menuCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
