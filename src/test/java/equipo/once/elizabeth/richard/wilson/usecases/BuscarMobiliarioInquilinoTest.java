package equipo.once.elizabeth.richard.wilson.usecases;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.mocks.MobiliarioServiceHappyPathMock;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.BuscarMobiliarioInquilinoRequest;
import equipo.once.elizabeth.richard.wilson.usecases.dtos.BuscarMobiliarioInquilinoResponse;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class BuscarMobiliarioInquilinoTest {

  @Test
  public void buscaElMobiliarioAsignadoAlInquilino(){
    Inquilino inquilino = new Inquilino();
    inquilino.codigo = "I-richard-1";
    BuscarMobiliarioInquilinoRequest request = new BuscarMobiliarioInquilinoRequest();

    BuscarMobiliarioInquilinoUseCase useCase = new BuscarMobiliarioInquilinoUseCase();
    useCase.mobiliarioService = new MobiliarioServiceHappyPathMock();

    request.inquilino = inquilino;
    useCase.request = request;

    useCase.solicitar();

    BuscarMobiliarioInquilinoResponse response = useCase.obtenerRespuesta();

    Assert.assertThat(response.mobiliario.inquilino , Is.is(inquilino));
  }
}
