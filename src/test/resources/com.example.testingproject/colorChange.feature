Feature: Changing the color of item changes its image
  Background:
    Given the user is on Hero Hoodie page

    Scenario Outline: Changing color
      When '<color>' is selected
      Then main image has the link '<href>'
      Examples:
        | color | href                                                                                                                                |
        | Black | https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/4eb2c46e52caa44ad0c1a1e7a8bca863/m/h/mh07-black_main_1.jpg |
        | Gray  | https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/4eb2c46e52caa44ad0c1a1e7a8bca863/m/h/mh07-gray_main_1.jpg  |
        | Green | https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/4eb2c46e52caa44ad0c1a1e7a8bca863/m/h/mh07-green_main_1.jpg |