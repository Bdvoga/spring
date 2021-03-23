package com.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
public class ItemController {
    @Autowired
    ItemService itemService;

    //Read
    @RequestMapping(method = RequestMethod.GET, value = "/item/{id}", produces = "text/plain")
    public @ResponseBody String get(@PathVariable Long id) {
        System.out.println(itemService.serviceFindById(id));

        if (itemService.serviceFindById(id) != null) {
            return itemService.serviceFindById(id).toString();
        } else {
            return "Item not found";
        }
    }

    //Delete
    @RequestMapping(method = RequestMethod.DELETE, value = "/itemDelete/{id}", produces = "text/plain")
    public @ResponseBody String delete(@PathVariable Long id) throws Exception {
        itemService.delete(id);

        return "Done!";
    }

    //Create
    @RequestMapping(method = RequestMethod.POST,
            value = "/itemSave",
            produces = "text/plain",
            params = {"name", "desc"})
    public @ResponseBody void save(
            HttpServletResponse resp,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "desc") String desc) throws IOException {

        Item item = new Item();
        item.setName(name);
        item.setDescription(desc);
        item.setDateCreated(new Date());
        item.setLastUpdateDate(new Date());

        resp.getWriter().println(itemService.save(item));
    }

    //Update
    @RequestMapping(method = RequestMethod.PUT,
            value = "/itemUpdate",
            produces = "text/plain",
            params = {"id", "name", "desc"})
    public @ResponseBody void update(
            HttpServletResponse resp,
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "desc") String desc) throws Exception {

        Item item = new Item();
        item.setId(id);
        item.setName(name);
        item.setDescription(desc);
        item.setLastUpdateDate(new Date());

        resp.getWriter().println(itemService.update(item));
    }
}