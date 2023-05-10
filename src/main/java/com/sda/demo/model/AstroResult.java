package com.sda.demo.model;

import java.util.List;

public record AstroResult(String message, Integer number, List<Astronaut> people) { }
