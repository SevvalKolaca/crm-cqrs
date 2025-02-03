package crm.cqrs.crm.cqrs.core.pipelines.auth;

import an.awesome.pipelinr.Command;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationBehavior implements Command.Middleware{

    @Override
    /* C --> komutun kendisi
    *  Next ile bir sonraki behavior'a iğlerletebiliriz.
    * */
    public <R, C extends Command<R>> R invoke(C c, Next<R> next) {
        // command çalışmadan önce...

         if(c instanceof AuthenticatedRequest)
         {
             Authentication auth = SecurityContextHolder.getContext().getAuthentication();
             if(auth == null || !auth.isAuthenticated())
                 throw new RuntimeException("Authentication required");

         }
        //command çalıştıktan sonra.
        return  next.invoke();
    }
}
