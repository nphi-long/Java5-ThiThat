package poly.sof302.service;

import poly.sof302.entities.Sanpham;

import java.util.List;

public interface ISanPhamService {
    public List<Sanpham> findAll();
    public void saveOrUpdate(Sanpham sp);
}
