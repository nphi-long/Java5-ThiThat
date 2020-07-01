package poly.sof302.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.sof302.entities.Sanpham;
import poly.sof302.repository.ISanPhamRepository;

import java.util.List;

@Service
public class SanPhamService implements ISanPhamService{
    @Autowired
    ISanPhamRepository spRepo;

    @Override
    public List<Sanpham> findAll() {
        return spRepo.findAll();
    }

    @Override
    public void saveOrUpdate(Sanpham sp) {
        spRepo.save(sp);
    }
}
