package me.hyunki.demospring51;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @NonNull // return 값 nonnull
    public String createEvent(@NonNull String name) {
        return null;
    }
}
