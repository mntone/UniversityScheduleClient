using Livet;
using System.Windows;

namespace Mntone.UniversitySchedule.Client.Demo
{
	public partial class App
		: Application
	{
		protected override void OnStartup( StartupEventArgs e )
		{
			base.OnStartup( e );
			DispatcherHelper.UIDispatcher = this.Dispatcher;
		}
	}
}