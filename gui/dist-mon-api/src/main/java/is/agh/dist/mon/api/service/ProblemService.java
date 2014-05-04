package is.agh.dist.mon.api.service;

import is.agh.dist.mon.api.dto.ProblemDto;

import java.util.List;

public interface ProblemService {
    public List<ProblemDto> findAll();
    public ProblemDto findById(int id);
}
