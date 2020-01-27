package org.kodejava.example.mybatis.controllers;

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
import java.util.UUID;

/**
 * @author Cesardl
 */
@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

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
        List<Record> records = recordMapper.getAllRecords();
        model.addAttribute("records", records);
        Record record = new Record();
        record.setId(generateId());
        model.addAttribute("record", record);
        return "registration";
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute(value = "record") Record record, BindingResult result) {
        validator.validate(record, result);
        ModelAndView mv = new ModelAndView("registration");
        if (!result.hasErrors()) {
            recordMapper.saveRecord(record);
            record = new Record();
            record.setId(generateId());
            mv.addObject("record", record);
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
            record = new Record();
            record.setId(generateId());
            mv.addObject("record", record);
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
            record = new Record();
            record.setId(generateId());
            mv.addObject("record", record);
        }
        mv.addObject("records", recordMapper.getAllRecords());
        return mv;
    }

    private int generateId() {
        int hash = UUID.randomUUID().hashCode();
        return hash > 0 ? hash : hash * -1;
    }
}
