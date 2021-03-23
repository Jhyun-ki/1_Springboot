package me.hyunki.demospring51;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository @Primary
public class HyunkiBookRepository implements  BookRepository{
}
