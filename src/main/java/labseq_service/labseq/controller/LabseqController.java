package labseq_service.labseq.controller;

import labseq_service.labseq.service.LabseqService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/labseq")
public class LabseqController {

    @Autowired
    private LabseqService labSeqService;

    @Operation(summary = "Get the l(n) value of the LabSeq sequence",
               description = "Returns the value of the LabSeq sequence at index n.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved l(n)")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @GetMapping("/{n}")
    public ResponseEntity<Long> getLabSeq(@PathVariable("n") long n) {
        // The index may be any non-negative integer number.
        if (n < 0) {
            return ResponseEntity.badRequest().body(null);
        }
        try {
            long result = labSeqService.getLabseq(n);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }  
}