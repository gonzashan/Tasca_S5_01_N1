package cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.domain.CountriesModel;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.domain.SucursalModel;
import cat.itacademy.barcelonactiva.sanmiguelalonso.gonzalo.s05.t01.n01.model.dto.SucursalDTO;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface ISucursalService {

    // Method showing all the records
    List<SucursalModel> getAllSucursal();
    // Method for saving a record
    SucursalModel addSucursal(SucursalModel newSucursalModel);
    // Method to delete a record
    void delete(int id) throws EntityNotFoundException;
    // Method returning a record requested
    SucursalModel getOne(int id) throws RuntimeException;

    SucursalDTO newSucursalDTO();

    List<CountriesModel> getCountriesModels();

    SucursalDTO updateSucursalDtoById(SucursalModel sucursalFoundIt);

    SucursalDTO convertToSucursalDTO(SucursalModel sucursal);

    List<SucursalDTO> getAllSucursalDTOS();

}
