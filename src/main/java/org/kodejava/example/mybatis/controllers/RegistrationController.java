package org.kodejava.example.mybatis.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kodejava.example.mybatis.domain.Record;
import org.kodejava.example.mybatis.persistence.RecordMapper;
import org.kodejava.example.mybatis.validator.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Cesardl
 */
@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    private static final Logger logger = LogManager.getLogger(RegistrationController.class);

    private RegistrationValidator validator;
    private RecordMapper recordMapper;

    @Autowired
    public void setValidator(RegistrationValidator validator) {
        this.validator = validator;
    }

    @Autowired
    public void setRecordMapper(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }

    @GetMapping
    public String showForm(ModelMap model) {
        logger.info("Loading records");
        List<Record> records = recordMapper.getAllRecords();
        model.addAttribute("records", records);
        logger.debug("Getting {} records", records.size());
        model.addAttribute("record", new Record());
        return "registration";
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute(value = "record") Record body, BindingResult result) {
        validator.validate(body, result);
        ModelAndView mv = new ModelAndView("registration");
        if (!result.hasErrors()) {
            recordMapper.saveRecord(body);
            mv.addObject("record", new Record());
        }
        mv.addObject("records", recordMapper.getAllRecords());
        return mv;
    }

    @PostMapping(value = "/update")
    public ModelAndView update(@ModelAttribute(value = "record") Record record, BindingResult result) {
        validator.validate(record, result);
        ModelAndView mv = new ModelAndView("registration");
        if (!result.hasErrors()) {
            recordMapper.updateRecord(record);
            mv.addObject("record", new Record());
        }
        mv.addObject("records", recordMapper.getAllRecords());
        return mv;
    }

    @PostMapping(value = "/delete")
    public ModelAndView delete(@ModelAttribute(value = "record") Record record, BindingResult result) {
        validator.validate(record, result);
        ModelAndView mv = new ModelAndView("registration");
        if (!result.hasErrors()) {
            recordMapper.deleteRecord(record.getId());
            mv.addObject("record", new Record());
        }
        mv.addObject("records", recordMapper.getAllRecords());
        return mv;
    }
}
