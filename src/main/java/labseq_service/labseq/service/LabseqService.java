package labseq_service.labseq.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class LabseqService {
    @Cacheable("labseq")
    public long getLabseq(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 0;
        if (n == 3) return 1;


        long ln_minus_4 = 0; // l(n-4)
        long ln_minus_3 = 1; // l(n-3)
        long ln_minus_2 = 0; // l(n-2)
        long ln_minus_1 = 1; // l(n-1)
        long ln = 0;         // l(n)

        for (long i = 4; i <= n; i++) {
            ln = ln_minus_4 + ln_minus_3;

            ln_minus_4 = ln_minus_3;
            ln_minus_3 = ln_minus_2;
            ln_minus_2 = ln_minus_1;
            ln_minus_1 = ln;
        }

        return ln;
    } 
}