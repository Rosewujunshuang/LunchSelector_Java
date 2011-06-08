package com.thoughtworks.repository;

import com.thoughtworks.database.DatabaseHelper;
import com.thoughtworks.model.Rule;
import org.junit.Test;
import org.neo4j.graphdb.Node;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RuleRepositoryTest {

    @Test
    public void shouldReturnAgeLessThanCategoryBasedOnRule() {
        int age = 10;

        RuleRepository ruleRepository = new RuleRepository();
        Node child = ruleRepository.evaluateRule(age, "Age");
        assertThat(child.getProperty(DatabaseHelper.NODE_NAME).toString(), is("Child"));
    }

    @Test
    public void shouldReturnAgeGreaterThanCategoryBasedOnRule() {
        int age = 66;

        RuleRepository ruleRepository = new RuleRepository();
        Node pensioner = ruleRepository.evaluateRule(age, "Age");
        assertThat(pensioner.getProperty(DatabaseHelper.NODE_NAME).toString(), is("Pensioner"));
    }

    @Test
    public void shouldReturnAgeBetweenCategoryBasedOnRule() {
        int age = 60;

        RuleRepository ruleRepository = new RuleRepository();
        Node adult = ruleRepository.evaluateRule(age, "Age");
        assertThat(adult.getProperty(DatabaseHelper.NODE_NAME).toString(), is("Adult"));
    }

    @Test
    public void shouldReturnAgeDefaultCategoryBasedOnRule() {
        int age = 0;

        RuleRepository ruleRepository = new RuleRepository();
        Node adult = ruleRepository.evaluateRule(age, "Age");
        assertThat(adult.getProperty(DatabaseHelper.NODE_NAME).toString(), is("Adult"));
    }

    @Test
    public void shouldReturnTenPercentDiscount() {
        int age = 3;

        RuleRepository ruleRepository = new RuleRepository();
        Node adult = ruleRepository.evaluateRule(age, "Quantity");
        assertThat(adult.getProperty(DatabaseHelper.NODE_NAME).toString(), is("10"));
    }

    @Test
    public void shouldReturnWeatherThereIsRule() {
        RuleRepository ruleRepository = new RuleRepository();
        boolean hasRule = ruleRepository.hasRule();
        assertThat(hasRule, is(true));
    }

    @Test
    public void shouldReturnAllTheRules() throws Exception {
        RuleRepository ruleRepository = new RuleRepository();
        List<Rule> listOfRules = ruleRepository.getRules();
        assertThat(listOfRules.size(), is(2));
    }

}