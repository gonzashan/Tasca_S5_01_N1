package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.services;


import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.domain.CountriesModel;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.domain.SucursalModel;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.repository.CountriesRepository;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalService implements ISucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;
    @Autowired
    private CountriesRepository countriesRepository;


    @Override
    public List<SucursalModel> getAllSucursal() {
        return (List<SucursalModel>) sucursalRepository.findAll();
    }

    @Override
    public SucursalModel addSucursal(SucursalModel newSucursalModel) {
        return sucursalRepository.save(newSucursalModel);
    }

    @Override
    public void delete(int pkId) throws EmptyResultDataAccessException {
        sucursalRepository.deleteById(pkId);
    }

    @Override
    public SucursalModel getOne(int pkId) throws EntityNotFoundException {

        Optional<SucursalModel> sucursalResponse = sucursalRepository.findById(pkId);
        SucursalModel sucursal = null;

        if(sucursalResponse.isPresent()) {
            sucursal = sucursalResponse.get();

        }else {
            throw new EntityNotFoundException("No em trobat cap sucursal amb id: " + pkId);
        }

        return sucursal;
    }


    public SucursalDTO newSucursalDTO()
    {
        SucursalDTO sucursalDTO = new SucursalDTO();
        // Sending a list of countries
        sucursalDTO.setCountriesList(getCountriesModels());
        return sucursalDTO;
    }

    public List<CountriesModel> getCountriesModels()
    {
        return (List<CountriesModel>) countriesRepository.findAll();
    }


    public SucursalDTO updateSucursalDtoById(SucursalModel sucursalFoundIt)
    {
        SucursalDTO sucursalDTO = convertToSucursalDTO(sucursalFoundIt);
        sucursalDTO.setCountriesList(getCountriesModels());
        return sucursalDTO;
    }


    public SucursalDTO convertToSucursalDTO(SucursalModel sucursal)
    {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
        sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
        sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
        sucursalDTO.setTipusSucursal(sucursalDTO.getTipusSucursal());
        return sucursalDTO;
    }


    //Method to get all records returning them into a List<SucursalDTO>
    public List<SucursalDTO> getAllSucursalDTOS()
    {
        Iterable<SucursalModel> sucursalModelList = sucursalRepository.findAll();
        List<SucursalDTO> sucursalDTOIterable = new ArrayList<>();

        for (SucursalModel sucursal : sucursalModelList) {
            SucursalDTO sucursalDTO = convertToSucursalDTO(sucursal);
            sucursalDTOIterable.add(sucursalDTO);
        }
        return sucursalDTOIterable;
    }
}
