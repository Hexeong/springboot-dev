package com.ohgiraffers.demoelasticbeanstalk.menu.service;

import com.ohgiraffers.demoelasticbeanstalk.menu.dto.MenuDto;
import com.ohgiraffers.demoelasticbeanstalk.menu.entity.Menu;
import com.ohgiraffers.demoelasticbeanstalk.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu registerMenu(MenuDto menuDto) {
        return menuRepository.save(new Menu(
                menuDto.getMenuName(),
                menuDto.getMenuPrice(),
                menuDto.getCategoryCode(),
                menuDto.getOrderableStatus()
        ));
    }

    public Menu findById(Integer menuCode) {
        return menuRepository.findById(menuCode).orElse(null);
    }

    public Menu updateMenu(MenuDto menuDto) {
        Optional<Menu> menu = menuRepository.findById(menuDto.getMenuCode());
        if (menu.isPresent()) {
            Menu foundMenu = menu.get();
            return foundMenu;
        }
        else throw new IllegalArgumentException("잘못된 menuCode로 조회중");
    }

    public void deleteMenu(Integer menuCode) {
        menuRepository.deleteById(menuCode);
    }
}
