package equipo.once.elizabeth.richard.wilson.mocks;

import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import equipo.once.elizabeth.richard.wilson.entities.dominio.SolicitudInquilino;
import equipo.once.elizabeth.richard.wilson.services.AreaComunService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AreaComunServiceHappyPathMock implements AreaComunService {
  AreaComun piscina = AreaComun.crear("A-piscina-1","Piscina");
  AreaComun areaBBQ = AreaComun.crear("A-BBQ-1", "BBQ");

  List<AreaComun> areasComunes = Arrays.asList(piscina, areaBBQ);
  @Override
  public void buscarDisponibilidad(AreaComun areaComun, SolicitudInquilino solicitudInquilino) {
  }

  @Override
  public boolean disponibleALafecha(String codigoArea, String fechaSolicitud) {
    return true;
  }

  @Override
  public AreaComun buscarPorCodigo(String codigoArea) {
    return new AreaComun();
  }

  @Override
  public List<AreaComun> buscarPorPalabra(String palabraBusqueda) {
    return
        areasComunes
            .stream()
            .filter(a -> a.nombre.toLowerCase().matches(palabraBusqueda.toLowerCase()))
            .collect(Collectors.toList());
  }
}
